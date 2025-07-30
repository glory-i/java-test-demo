package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RoleUpdateRequest {
public int roleId;
public String roleName;
public String roleDescription;
public String roleIsPublic;
public String roleStatus;
public String roleCreatedAt;
public String roleUpdatedAt;
public int rolePrivilegeId;
public int rolePrivilegeRoleId;
public String rolePrivilegePrivilegeCode;
public String rolePrivilegeStatus;
public String rolePrivilegeCreatedAt;
public String rolePrivilegeUpdatedAt;
}
