package qucoon.mod.SpringServerless.controller;



import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;

import org.springframework.web.bind.annotation.*;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.LoginResponse;
import qucoon.mod.SpringServerless.service.AuthenticationService;
import qucoon.mod.SpringServerless.utility.Environment;

import javax.validation.Valid;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final Environment environment;

    public AuthenticationController(AuthenticationService authenticationService,
                                    Environment environment) {
        this.authenticationService = authenticationService;
        this.environment = environment;
    }

    @PostMapping("/initiate-enrollment")
    public BaseResponse initiateEnrollment(
            @Valid @RequestBody InitiateEnrollmentRequest request) {
        return authenticationService.initiateEnrollment(request);
    }

    @PostMapping("/complete-enrollment")
    public BaseResponse completeEnrollment(
            @Valid @RequestBody CompleteEnrollmentRequest request) {
        return authenticationService.completeEnrollment(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }

    @PostMapping("/initiate-password-reset")
    public BaseResponse initiatePasswordReset(
            @Valid @RequestBody InitiatePasswordResetRequest request) {
        return authenticationService.initiatePasswordReset(request);
    }

    @PostMapping("/complete-password-reset")
    public BaseResponse completePasswordReset(
            @Valid @RequestBody CompletePasswordResetRequest request) {
        return authenticationService.completePasswordReset(request);
    }

    @PostMapping("/change-password")
    public BaseResponse changePassword(
            @Valid @RequestBody ChangePasswordRequest request) {
        return authenticationService.changePassword(request);
    }

    @PostMapping("/resend-otp")
    public BaseResponse resendOtp(
            @Valid @RequestBody InitiatePasswordResetRequest request) {
        return authenticationService.resendOtp(request);
    }

//    @GetMapping("/user-details")
//    public LoginResponse userDetails(
//            @RequestHeader("Authorization") String authorization,
//            @PathVariable String stage) {
//        // Determine module name from controller class
//        String controllerName = getClass().getSimpleName().replace("Controller", "");
//        String module = camelToSnakeCase(controllerName).toUpperCase();
//        ModulePrivilege privilege = new ModulePrivilege(module, PrivilegeConstant.ALL);
//        JwtUtil jwtUtil = new JwtUtil();
//        String token = jwtUtil.generateJwt(
//                teacher.getTeacherEmail(),
//                userInfoJson,
//                privilege
//        );
//        return environment.jwtUtil()
//                .privilegeAuthorization(privilege, authorization);
//    }

    //testng for pipeline deployment.
    @GetMapping("/load-config")
    public BaseResponse loadAppConfig() {
        return authenticationService.loadAppConfig();
    }
}
