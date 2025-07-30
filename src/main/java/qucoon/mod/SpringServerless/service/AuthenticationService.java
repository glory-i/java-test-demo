

package qucoon.mod.SpringServerless.service;

import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.model.entity.LoginHistory;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.Privilege;
import qucoon.mod.SpringServerless.model.entity.Role;
import qucoon.mod.SpringServerless.model.entity.RolePrivilege;
import qucoon.mod.SpringServerless.model.entity.UserOtp;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.LoginResponse;
import qucoon.mod.SpringServerless.repository.*;
import qucoon.mod.SpringServerless.repository.UserRepository;
import qucoon.mod.SpringServerless.utility.CredentialUtils;
import qucoon.mod.SpringServerless.utility.Environment;
import qucoon.mod.SpringServerless.utility.TimeUtil;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import qucoon.mod.SpringServerless.utility.exception.CustomExceptions;
import qucoon.mod.SpringServerless.utility.model.request.ModulePrivilege;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import qucoon.mod.SpringServerless.utility.JwtUtility;


@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthRepository authRepository;
    private final UserService userService;
    private final LoginHistoryRepository loginHistoryRepository;
    private final UserOtpRepository userOtpRepository;
    private final RoleRepository roleRepository;
    private final RolePrivilegeRepository rolePrivilegeRepository;
    private final ModuleRepository moduleRepository;
    private final PrivilegeRepository privilegeRepository;
    private final Environment environment;
    private final EmailService emailService;
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private static final int IP_RATE_LIMIT = 5; // max requests per window
    private static final Duration IP_RATE_WINDOW = Duration.ofMinutes(1);
    // Track per-IP request counts + window expiry
    private final Map<String, AtomicInteger> ipCounts = new ConcurrentHashMap<>();
    private final Map<String, LocalDateTime> ipResetTimes = new ConcurrentHashMap<>();
    // Minimum 8 characters, at least one uppercase, one lowercase, one digit, one special character
    private static final String PASSWORD_PATTERN = "^(?=.{8,}$)(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public AuthenticationService(UserRepository userRepository,
                                 UserService userService,
                                 LoginHistoryRepository loginHistoryRepository,
                                 UserOtpRepository userOtpRepository,
                                 RoleRepository roleRepository,
                                 RolePrivilegeRepository rolePrivilegeRepository,
                                 ModuleRepository moduleRepository,
                                 PrivilegeRepository privilegeRepository,
                                 Environment environment,
                                 EmailService emailService,
                                 AuthRepository authRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.loginHistoryRepository = loginHistoryRepository;
        this.userOtpRepository = userOtpRepository;
        this.roleRepository = roleRepository;
        this.rolePrivilegeRepository = rolePrivilegeRepository;
        this.moduleRepository = moduleRepository;
        this.privilegeRepository = privilegeRepository;
        this.environment = environment;
        this.emailService = emailService;
        this.authRepository = authRepository;
    }

    public BaseResponse initiateEnrollment(InitiateEnrollmentRequest request) {
        String passwordConcat = request.getUserPassword().trim();
        if(!isStrongPassword(passwordConcat)){
            throw new CustomExceptions.BadRequestException("Minimum 8 characters required for password, at least one uppercase, one lowercase, one digit, one special character");
        }
        // Check existing user
        User existing = userRepository.readByUserEmail(request.getUserEmail())
                .stream().findFirst().orElse(null);
        if (existing != null && !"PENDING".equals(existing.getUserStatus())) {
            throw new CustomExceptions.BadRequestException("user already exists!");
        }

        int result;
        if (existing != null && "PENDING".equals(existing.getUserStatus())) {
            // update existing
            UserUpdateRequest updateReq = new UserUpdateRequest();
            // Default plain values - Encrypted value overwrites it later
            
          updateReq.setUserEmail (request.getUserEmail ());
          updateReq.setUserFirstName (request.getUserFirstName ());
          updateReq.setUserLastName (request.getUserLastName ());
          updateReq.setUserPassword (request.getUserPassword ());
          updateReq.setUserPhoneNumber (request.getUserPhoneNumber ());
          updateReq.setUserJobRoleAlias (request.getUserJobRoleAlias ());
            updateReq.setUserId(existing.getUserId());

            String encPassword = CredentialUtils.bcryptHash(passwordConcat);
            updateReq.setUserPassword(encPassword);
            updateReq.setUserStatus("PENDING");
            BaseResponse resp = userService.update(updateReq);
            result = ResponseConstant.INSTANCE.getSUCCESS().getResponseCode().equals(resp.getResponseCode()) ? 1 : 0;

        } else {
            // create new
            User newUser = new User();

            String encPassword = CredentialUtils.bcryptHash(passwordConcat);
            // Default plain values - Encrypted value overwrites it later
            
            newUser.setUserEmail (request.getUserEmail ());
            newUser.setUserFirstName (request.getUserFirstName ());
            newUser.setUserLastName (request.getUserLastName ());
            newUser.setUserPassword (request.getUserPassword ());
            newUser.setUserPhoneNumber (request.getUserPhoneNumber ());
            newUser.setUserJobRoleAlias (request.getUserJobRoleAlias ());
            newUser.setUserPassword(encPassword);
            newUser.setUserStatus("PENDING");
            newUser.setUserEmail(request.getUserEmail());

            newUser.setUserLastLoginDate("");
            newUser.setUserLoginCount(0);
            newUser.setUserLastLoginIpAddress(environment.ipAddress);
            result = userRepository.create(newUser);
        }
        if (result < 1) {
            throw new CustomExceptions.FailedToCreateRecord("Unable to create account");
        }

        // Send OTP email
        String otp = generateOtp(request.getUserEmail());
        emailService.sendSimpleEmail(
                request.getUserEmail(),
                emailService.MSG_ENROLLMENT_TITLE,
                String.format(emailService.MSG_ENROLLMENT_BODY, otp)
        );

        return new BaseResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                "OTP has been sent."
        );
    }

    public BaseResponse completeEnrollment(CompleteEnrollmentRequest request) {
        User user = userRepository.readByUserEmail(request.getUserEmail())
                .stream().findFirst()
                .orElseThrow(() -> new CustomExceptions.UnableToLocateRecordException("User has not initiated enrollment"));
        if ("ACTIVE".equals(user.getUserStatus())) {
            throw new CustomExceptions.ActivityAlreadyPerformedException("User is already active");
        }
        validateOtp(request.getOtp(), request.getUserEmail());
        user.setUserStatus("ACTIVE");
        userRepository.update(user);
        return new BaseResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage()
        );
    }

    public LoginResponse login(LoginRequest request) {
        String ip = environment.ipAddress;
        if(enforceRateLimit(ip)){
            throw new CustomExceptions.BadRequestException("Too many requests from your IP; try again later.");
        }

        User user = userRepository
                .readByUserEmail(request.getUserEmail())
                .stream().findFirst()
                .orElseThrow(() -> new CustomExceptions.UnableToLocateRecordException("User has not initiated enrollment"));

        //Check if account is disabled
        if ("DISABLED".equals(user.getUserStatus())) {
            emailService.sendSimpleEmail(
                    user.getUserEmail(),
                    emailService.MSG_DISABLE_TITLE,
                    emailService.MSG_DISABLE_BODY
            );
            throw new CustomExceptions.BadRequestException("Your account has been disabled. To regain access, please begin the password reset process using the OTP verification.");
        }

        // Verify status
        if ("PENDING".equals(user.getUserStatus())) {
            throw new CustomExceptions.BadRequestException("Invalid Credentials");
        }
        if (!"ACTIVE".equals(user.getUserStatus())) {
            throw new CustomExceptions.BadRequestException("Request failed with user status: " + user.getUserStatus());
        }

        // Validate password
        boolean valid = CredentialUtils.bcryptValidate(request.getUserPassword(), user.getUserPassword());
        if (!valid) {
            // increment failed attempts
            int attempts = Optional.ofNullable(user.getUserLoginCount()).orElse(0) + 1;
            user.setUserLoginCount(attempts);
            int attemptsRemaining = MAX_FAILED_ATTEMPTS - attempts;

            // DISABLE profile if Failed count is exceeded
            if (attempts >= MAX_FAILED_ATTEMPTS) {
                user.setUserStatus("DISABLED");
                //Profile is now disabled - send disabled notification
                emailService.sendSimpleEmail(
                        user.getUserEmail(),
                        emailService.MSG_DISABLE_TITLE,
                        emailService.MSG_DISABLE_BODY
                );

            }else{
                //Profile will be disabled - send remaining count before disabled notification
                emailService.sendSimpleEmail(
                        user.getUserEmail(),
                        emailService.MSG_LOGINFAILED_TITLE,
                        String.format(emailService.MSG_LOGINFAILED_BODY, TimeUtil.getTime(),TimeUtil.getDate(), attemptsRemaining)
                );
            }
            userRepository.update(user);
            throw new CustomExceptions.BadRequestException(String.format("Invalid Credentials. Profile will be DISABLED after %s more failed login attempt.",attemptsRemaining));
        }

        //Successful authentication reset counters
        user.setUserLoginCount(0);
        user.setUserLastLoginDate(TimeUtil.getCurrentDateTimeString());
        user.setUserLastLoginIpAddress(ip);
        authRepository.updateLogin(user);

        ipCounts.remove(ip);
        ipResetTimes.remove(ip);

        //Record login history
        LoginHistory history = new LoginHistory();
        history.setLoginHistoryUsername(request.getUserEmail());
        history.setLoginHistoryDeviceId(request.getDeviceId());
        history.setLoginHistoryLatitude(request.getLatitude());
        history.setLoginHistoryLongitude(request.getLongitude());
        history.setLoginHistoryIpAddress(environment.ipAddress);
        history.setLoginHistoryStatus("ACTIVE");
        loginHistoryRepository.create(history);

        emailService.sendSimpleEmail(
                user.getUserEmail(),
                emailService.MSG_SUCCESS_TITLE,
                String.format(emailService.MSG_SUCCESS_BODY, TimeUtil.getTime(),TimeUtil.getDate())
        );

        //Build response and JWT
        LoginResponse resp = buildLoginResponse(user);
        return resp;
    }


    private boolean enforceRateLimit(String ip) {
        LocalDateTime now = LocalDateTime.now();
        // reset window if expired
        ipResetTimes.compute(ip, (k, expiry) -> {
            if (expiry == null || now.isAfter(expiry)) {
                ipCounts.put(ip, new AtomicInteger(0));
                return now.plus(IP_RATE_WINDOW);
            }
            return expiry;
        });
        AtomicInteger counter = ipCounts.computeIfAbsent(ip, k -> new AtomicInteger(0));
        int count = counter.incrementAndGet();
        System.out.println("IP: "+ip+" Count:"+count);
        if (count > IP_RATE_LIMIT) {
            System.out.println("IP: "+ip+" Count:"+count+ " Too many requests from your IP; try again later.");
            return true;
        }
        return false;
    }

    private LoginResponse buildLoginResponse(User user) {
        System.out.println(user.getUserId());
        System.out.println(user.toString());
        Gson gson = new Gson();
        LoginResponse resp = new LoginResponse();
        resp.setResponseCode(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode());
        resp.setResponseMessage(ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage());
        resp.setUserEmail(user.getUserEmail());

        // reset environment
        resp.setData(user);
        environment.userInfo = resp;

        // default role
        int roleId = 100;
        List<ModulePrivilege> rolePrivileges = rolePrivilegeRepository
                .readByRolePrivilegeRoleId(roleId)
                .stream()
                .map(it -> new ModulePrivilege(
                        it.getRolePrivilegePrivilegeCode().split("\\|")[1],
                        it.getRolePrivilegePrivilegeCode().split("\\|")[0]
                ))
                .collect(Collectors.toList());

        JSONObject userInfoJson = new JSONObject(gson.toJson(resp));
        String token = new JwtUtility().generateJwt(
                user.getUserEmail(), userInfoJson, rolePrivileges
        );
        resp.setToken(token);
        resp.setPrivileges(rolePrivileges.stream()
                .map(mp -> mp.getModule() + "|" + mp.getPrivilege())
                .collect(Collectors.toList())
        );
        user.setUserPassword("");
        resp.setData(user);

        return resp;
    }


    public BaseResponse resendOtp(InitiatePasswordResetRequest request) {
        ensureUserExists(request.getUserEmail());
        String otp = generateOtp(request.getUserEmail());

        emailService.sendSimpleEmail(
                request.getUserEmail(),
                emailService.MSG_OTP_TITLE,
                String.format(emailService.MSG_OTP_BODY, otp)
        );

        return new BaseResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                "OTP has been sent."
        );
    }

    public BaseResponse initiatePasswordReset(InitiatePasswordResetRequest request) {
        return resendOtp(request);
    }

    public BaseResponse completePasswordReset(CompletePasswordResetRequest request) {
        String passwordConcat = request.getUserPassword().trim();
        if(!isStrongPassword(passwordConcat)){
            throw new CustomExceptions.BadRequestException("Minimum 8 characters required for password, at least one uppercase, one lowercase, one digit, one special character");
        }

        User user = userRepository
                .readByUserEmail(request.getUserEmail())
                .stream().findFirst()
                .orElseThrow(() -> new CustomExceptions.UnableToLocateRecordException("User does not exist."));

        validateOtp(request.getOtp(), request.getUserEmail());

        user.setUserPassword(CredentialUtils.bcryptHash(request.getUserPassword()));
        user.setUserStatus("ACTIVE");
        user.setUserLoginCount(0);
        userRepository.update(user);

        return new BaseResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage()
        );
    }

    public BaseResponse changePassword(ChangePasswordRequest request) {
        User user = userRepository.readByUserEmail(request.getUserEmail())
                .stream().findFirst()
                .orElseThrow(() -> new CustomExceptions.UnableToLocateRecordException("user does not already exists."));
        if (!CredentialUtils.bcryptValidate(request.getOldPassword(), user.getUserPassword())) {
            throw new CustomExceptions.BadRequestException("Incorrect Old Password");
        }

        user.setUserStatus("ACTIVE");
        user.setUserPassword(CredentialUtils.bcryptHash(request.getUserPassword()));
        userRepository.update(user);
        return new BaseResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage()
        );
    }

    private String generateOtp(String username) {
        //ensureUserExists(username);
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        userOtpRepository.readByUserOtpUsername(username)
                .stream().findFirst()
                .ifPresent(u -> userOtpRepository.delete(u.getUserOtpId()));
        UserOtp uo = new UserOtp( );
        uo.setUserOtpUsername(username);
        uo.setUserOtpStatus("ACTIVE");
        uo.setUserOtpOtp(CredentialUtils.bcryptHash(otp));
        userOtpRepository.create(uo);
        return otp;
    }

    private void ensureUserExists(String username) {
        userRepository.readByUserEmail(username)
                .stream().findFirst()
                .orElseThrow(() -> new CustomExceptions.UnableToLocateRecordException("Email does not exists"));
    }

    private boolean validateOtp(String otp, String username) {
        UserOtp uo = userOtpRepository.readByUserOtpUsername(username)
                .stream().findFirst()
                .orElseThrow(() -> new CustomExceptions.InvalidOtpException("OTP is invalid."));
        String encVal = CredentialUtils.bcryptHash(otp);

        boolean isValid = CredentialUtils.bcryptValidate(otp,uo.getUserOtpOtp());

        if (!isValid) {
            throw new CustomExceptions.InvalidOtpException("OTP is invalid.");
        }
        if (isExpired(uo.getUserOtpUpdatedAt().toString())) {
            throw new CustomExceptions.OtpExpiredException("OTP is expired.");
        }
        return true;
    }


    private boolean isExpired(String dateTime) {

        DateTimeFormatter spaceFormatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd[ ][HH:mm:ss]") // Handle with space or T
                .optionalStart()
                .appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true) // Handle 0-9 fractional digits
                .toFormatter()
                ;   ;

        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        LocalDateTime then;
        try {
            // First try parsing with space format
            then = LocalDateTime.parse(dateTime, spaceFormatter);
        } catch (Exception e1) {
            try {
                // If space format fails, try ISO format
                then = LocalDateTime.parse(dateTime, isoFormatter);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Invalid date format. Use either:\n" +
                        "1. yyyy-MM-dd HH:mm:ss[.SSS...]\n" +
                        "2. yyyy-MM-dd'T'HH:mm:ss[.SSS...]");
            }
        }

        long minsThen = then.toEpochSecond(ZoneOffset.UTC) / 60; //atZone(ZoneId.systemDefault()).toEpochSecond() / 60;
        long minsNow = LocalDateTime.now(ZoneOffset.UTC)
                .toEpochSecond(ZoneOffset.UTC)
                / 60;//.now().atZone(ZoneId.systemDefault()).toEpochSecond() / 60;
        return (minsNow - minsThen) > 5;
    }

    public BaseResponse loadAppConfig() {
        // 1) LOAD MODULES
        List<String> moduleNames = Arrays.asList(
"","AuditLog","CheckerQueue","Course","LoginHistory","Module","Privilege","Role","RolePrivilege","User","UserOtp"
        );

        moduleRepository.truncate();

        List<Module> modules = new ArrayList<>();
        for (String name : moduleNames) {
            Module md = new Module();
            md.setModuleDescription(name);
            md.setModuleName(name);
            md.setModuleStatus("ACTIVE");
            modules.add(md);
        }
        moduleRepository.bulkCreate(modules);

        // 2) LOAD PRIVILEGES
        privilegeRepository.truncate();

        // helper to build privileges for a given action
        List<Privilege> createPrivileges = buildPrivileges(moduleNames, "CREATE");
        privilegeRepository.bulkCreate(createPrivileges);

        List<Privilege> updatePrivileges = buildPrivileges(moduleNames, "UPDATE");
        privilegeRepository.bulkCreate(updatePrivileges);

        List<Privilege> deletePrivileges = buildPrivileges(moduleNames, "DELETE");
        privilegeRepository.bulkCreate(deletePrivileges);

        List<Privilege> readPrivileges = buildPrivileges(moduleNames, "READ");
        privilegeRepository.bulkCreate(readPrivileges);

        List<Privilege> checkerPrivileges = buildPrivileges(moduleNames, "CHECKER");
        privilegeRepository.bulkCreate(checkerPrivileges);

        // 3) CREATE SUPER_ADMIN ROLE
        Role superAdminRole = new Role();
        superAdminRole.setRoleName("SUPER_ADMIN");
        superAdminRole.setRoleDescription("SUPER_ADMIN");
        superAdminRole.setRoleStatus("ACTIVE");

        int roleId = roleRepository.create(superAdminRole);

        // 4) ASSIGN ALL PRIVILEGES TO SUPER_ADMIN
        List<Privilege> allPrivileges = new ArrayList<>();
        allPrivileges.addAll(createPrivileges);
        allPrivileges.addAll(updatePrivileges);
        allPrivileges.addAll(deletePrivileges);
        allPrivileges.addAll(readPrivileges);
        allPrivileges.addAll(checkerPrivileges);

        List<RolePrivilege> rolePrivileges = new ArrayList<>();
        for (Privilege priv : allPrivileges) {
            RolePrivilege rp = new RolePrivilege();
            rp.setRolePrivilegePrivilegeCode(priv.getPrivilegeCode());
            rp.setRolePrivilegeId(priv.getPrivilegeId());
            rp.setRolePrivilegeRoleId(Math.toIntExact(roleId));
            rp.setRolePrivilegeStatus("ACTIVE");
            rolePrivileges.add(rp);
        }
        rolePrivilegeRepository.bulkCreate(rolePrivileges);

        return new BaseResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage()
        );
    }

    private List<Privilege> buildPrivileges(List<String> modules, String action) {
        List<Privilege> list = new ArrayList<>();
        for (String module : modules) {
            String code = module + "|" + action;
            Privilege pr = new Privilege();
            pr.setPrivilegeCode(code);
            pr.setPrivilegeModuleName(module);
            pr.setPrivilegeName(action);
            pr.setPrivilegeStatus("ACTIVE");
            pr.setPrivilegeDescription(code);
            list.add(pr);
        }
        return list;
    }

    public static boolean isStrongPassword(String password) {
        if (password == null) {
            return false;
        }
        return pattern.matcher(password).matches();
    }


}
