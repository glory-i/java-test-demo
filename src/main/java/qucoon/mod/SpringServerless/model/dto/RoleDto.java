package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Role;


@Data
public class RoleDto  {

private Integer roleId;
private String roleName;
private String roleDescription;
private String roleIsPublic;
private String roleStatus;
private String roleCreatedAt;
private String roleUpdatedAt;
private Integer rolePrivilegeId;
private Integer rolePrivilegeRoleId;
private String rolePrivilegePrivilegeCode;
private String rolePrivilegeStatus;
private String rolePrivilegeCreatedAt;
private String rolePrivilegeUpdatedAt;

public static RoleDto from(Role p) {
    RoleDto dto = new RoleDto();

    dto.setRoleId(p.getRoleId());
    dto.setRoleName(p.getRoleName());
    dto.setRoleDescription(p.getRoleDescription());
    dto.setRoleIsPublic(p.getRoleIsPublic());
    dto.setRoleStatus(p.getRoleStatus());
    dto.setRoleCreatedAt(p.getRoleCreatedAt());
    dto.setRoleUpdatedAt(p.getRoleUpdatedAt());
    dto.setRolePrivilegeId(p.getRolePrivilegeId());
    dto.setRolePrivilegeRoleId(p.getRolePrivilegeRoleId());
    dto.setRolePrivilegePrivilegeCode(p.getRolePrivilegePrivilegeCode());
    dto.setRolePrivilegeStatus(p.getRolePrivilegeStatus());
    dto.setRolePrivilegeCreatedAt(p.getRolePrivilegeCreatedAt());
    dto.setRolePrivilegeUpdatedAt(p.getRolePrivilegeUpdatedAt());
    return dto;
   }
}
