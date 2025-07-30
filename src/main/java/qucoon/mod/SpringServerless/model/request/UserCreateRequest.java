package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class UserCreateRequest {
@NotNull(message = "userId  is required")
public int userId ;
@NotNull(message = "userRoleId  is required")
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
@NotNull(message = "userLoginCount is required")
public int userLoginCount;
public String userLastLoginDate;
public String userLastLoginIpAddress;
}
