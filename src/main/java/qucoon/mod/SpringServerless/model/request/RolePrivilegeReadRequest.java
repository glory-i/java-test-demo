package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RolePrivilegeReadRequest {
@NotEmpty(message = "Roleprivilegeid is required")
public int rolePrivilegeId;
@NotEmpty(message = "Roleprivilegeroleid is required")
public int rolePrivilegeRoleId;
@NotEmpty(message = "Roleprivilegeprivilegecode is required")
public String rolePrivilegePrivilegeCode;
@NotEmpty(message = "Roleprivilegestatus is required")
public String rolePrivilegeStatus;
@NotEmpty(message = "Roleprivilegecreatedat is required")
public String rolePrivilegeCreatedAt;
@NotEmpty(message = "Roleprivilegeupdatedat is required")
public String rolePrivilegeUpdatedAt;
}
