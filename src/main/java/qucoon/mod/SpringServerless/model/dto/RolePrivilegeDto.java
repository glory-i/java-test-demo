package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.RolePrivilege;


@Data
public class RolePrivilegeDto  {

private Integer rolePrivilegeId;
private Integer rolePrivilegeRoleId;
private String rolePrivilegePrivilegeCode;
private String rolePrivilegeStatus;
private String rolePrivilegeCreatedAt;
private String rolePrivilegeUpdatedAt;

public static RolePrivilegeDto from(RolePrivilege p) {
    RolePrivilegeDto dto = new RolePrivilegeDto();

    dto.setRolePrivilegeId(p.getRolePrivilegeId());
    dto.setRolePrivilegeRoleId(p.getRolePrivilegeRoleId());
    dto.setRolePrivilegePrivilegeCode(p.getRolePrivilegePrivilegeCode());
    dto.setRolePrivilegeStatus(p.getRolePrivilegeStatus());
    dto.setRolePrivilegeCreatedAt(p.getRolePrivilegeCreatedAt());
    dto.setRolePrivilegeUpdatedAt(p.getRolePrivilegeUpdatedAt());
    return dto;
   }
}
