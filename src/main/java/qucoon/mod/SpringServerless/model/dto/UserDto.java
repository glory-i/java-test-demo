package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.User;


@Data
public class UserDto  {

private Integer userId ;
private Integer userRoleId ;
private String userEmail ;
private String userFirstName ;
private String userLastName ;
private String userPassword ;
private String userPhoneNumber ;
private String userJobRoleAlias ;
private String userStatus ;
private String userCreatedAt  ;
private String userUpdatedAt ;
private Integer userLoginCount;
private String userLastLoginDate;
private String userLastLoginIpAddress;

public static UserDto from(User p) {
    UserDto dto = new UserDto();

    dto.setUserId (p.getUserId ());
    dto.setUserRoleId (p.getUserRoleId ());
    dto.setUserEmail (p.getUserEmail ());
    dto.setUserFirstName (p.getUserFirstName ());
    dto.setUserLastName (p.getUserLastName ());
    dto.setUserPassword (p.getUserPassword ());
    dto.setUserPhoneNumber (p.getUserPhoneNumber ());
    dto.setUserJobRoleAlias (p.getUserJobRoleAlias ());
    dto.setUserStatus (p.getUserStatus ());
    dto.setUserCreatedAt  (p.getUserCreatedAt  ());
    dto.setUserUpdatedAt (p.getUserUpdatedAt ());
    dto.setUserLoginCount(p.getUserLoginCount());
    dto.setUserLastLoginDate(p.getUserLastLoginDate());
    dto.setUserLastLoginIpAddress(p.getUserLastLoginIpAddress());
    return dto;
   }
}
