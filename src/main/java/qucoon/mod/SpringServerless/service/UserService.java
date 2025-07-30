
package   qucoon.mod.SpringServerless.service;


import qucoon.mod.SpringServerless.utility.exception.CustomExceptions;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;
import qucoon.mod.SpringServerless.model.entity.User;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.*;
import qucoon.mod.SpringServerless.utility.LocalDateTimeTypeAdapter;
import qucoon.mod.SpringServerless.repository.*;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.UserPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.UserDto;


@Service
public class UserService {

    private final UserRepository userRepository;
    private  final Gson GSON;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(UserCreateRequest request) {

        User user = GSON.fromJson(GSON.toJson(request), User.class);
        if (user.getUserStatus() == null) {
            user.setUserStatus("ACTIVE");
        }
        userRepository.create(user);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<UserCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            User[] userArray = GSON.fromJson(json, User[].class);
            List<User> users = Arrays.asList(userArray);
            userRepository.bulkCreate(users);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(UserUpdateRequest request) {
        User user = userRepository.readByUserId (request.getUserId ());
        if (user == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        userRepository.update(user);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int userId ) {
        int updateResponse = userRepository.delete(userId );
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public UserReadListResponse read() {
        List<User> users = userRepository.read();
       if(users == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new UserReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), users);
    }
   public UserReadPagedResponse search(UserFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       UserPage page = userRepository.findUser(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<UserDto> dtos = page.getData().stream()
            .map(UserDto::from)
            .collect(Collectors.toList());
    return new UserReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public UserReadSingleResponse readByUserId (int userid ) {
        User user = userRepository.readByUserId (userid );
        if (user == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new UserReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                user);
    }
    public UserReadListResponse readByUserRoleId (int userroleid ) {
        List<User> users = userRepository.readByUserRoleId (userroleid );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserEmail (String useremail ) {
        List<User> users = userRepository.readByUserEmail (useremail );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserFirstName (String userfirstname ) {
        List<User> users = userRepository.readByUserFirstName (userfirstname );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserLastName (String userlastname ) {
        List<User> users = userRepository.readByUserLastName (userlastname );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserPassword (String userpassword ) {
        List<User> users = userRepository.readByUserPassword (userpassword );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserPhoneNumber (String userphonenumber ) {
        List<User> users = userRepository.readByUserPhoneNumber (userphonenumber );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserJobRoleAlias (String userjobrolealias ) {
        List<User> users = userRepository.readByUserJobRoleAlias (userjobrolealias );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserStatus (String userstatus ) {
        List<User> users = userRepository.readByUserStatus (userstatus );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserCreatedAt  (String usercreatedat  ) {
        List<User> users = userRepository.readByUserCreatedAt  (usercreatedat  );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserUpdatedAt (String userupdatedat ) {
        List<User> users = userRepository.readByUserUpdatedAt (userupdatedat );
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserLoginCount(int userlogincount) {
        List<User> users = userRepository.readByUserLoginCount(userlogincount);
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserLastLoginDate(String userlastlogindate) {
        List<User> users = userRepository.readByUserLastLoginDate(userlastlogindate);
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
    public UserReadListResponse readByUserLastLoginIpAddress(String userlastloginipaddress) {
        List<User> users = userRepository.readByUserLastLoginIpAddress(userlastloginipaddress);
        return new UserReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        users);
    }
}
