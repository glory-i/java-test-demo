package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class PrivilegeCreateRequest {
@NotEmpty(message = "privilegeCode is required")
public String privilegeCode;
@NotEmpty(message = "privilegeName is required")
public String privilegeName;
@NotEmpty(message = "privilegeModuleName is required")
public String privilegeModuleName;
public String privilegeDescription;
}
