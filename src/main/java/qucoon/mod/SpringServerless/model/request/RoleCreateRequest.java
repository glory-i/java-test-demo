package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class RoleCreateRequest {
@NotEmpty(message = "roleName is required")
public String roleName;
public String roleDescription;
@NotEmpty(message = "roleIsPublic is required")
public String roleIsPublic;
@NotNull(message = "rolePrivilegeId is required")
public int rolePrivilegeId;
@NotNull(message = "rolePrivilegeRoleId is required")
public int rolePrivilegeRoleId;
public String rolePrivilegePrivilegeCode;
public String rolePrivilegeStatus;
@NotEmpty(message = "rolePrivilegeCreatedAt is required")
public String rolePrivilegeCreatedAt;
@NotEmpty(message = "rolePrivilegeUpdatedAt is required")
public String rolePrivilegeUpdatedAt;
}
