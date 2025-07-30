package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserUpdateRequest {
public int userId ;
public int userRoleId ;
public String userEmail ;
public String userFirstName ;
public String userLastName ;
public String userPassword ;
public String userPhoneNumber ;
public String userJobRoleAlias ;
public String userStatus ;
public String userCreatedAt  ;
public String userUpdatedAt ;
public int userLoginCount;
public String userLastLoginDate;
public String userLastLoginIpAddress;
}
