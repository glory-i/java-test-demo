package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
@Data
public class InitiateEnrollmentRequest {


@NotEmpty(message = "userEmail  is required")
private String userEmail ;
@NotEmpty(message = "userFirstName  is required")
private String userFirstName ;
@NotEmpty(message = "userLastName  is required")
private String userLastName ;
@NotEmpty(message = "userPassword  is required")
private String userPassword ;
@NotEmpty(message = "userPhoneNumber  is required")
private String userPhoneNumber ;
@NotEmpty(message = "userJobRoleAlias  is required")
private String userJobRoleAlias ;

}
