package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserFilterRequest {

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
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
