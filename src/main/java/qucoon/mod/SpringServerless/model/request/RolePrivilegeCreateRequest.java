package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class RolePrivilegeCreateRequest {
@NotNull(message = "rolePrivilegeRoleId is required")
public int rolePrivilegeRoleId;
public String rolePrivilegePrivilegeCode;
}
