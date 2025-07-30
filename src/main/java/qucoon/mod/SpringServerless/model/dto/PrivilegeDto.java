package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Privilege;


@Data
public class PrivilegeDto  {

private Integer privilegeId;
private String privilegeCode;
private String privilegeName;
private String privilegeModuleName;
private String privilegeDescription;
private String privilegeStatus;
private String privilegeCreatedAt;
private String privilegeUpdatedAt;

public static PrivilegeDto from(Privilege p) {
    PrivilegeDto dto = new PrivilegeDto();

    dto.setPrivilegeId(p.getPrivilegeId());
    dto.setPrivilegeCode(p.getPrivilegeCode());
    dto.setPrivilegeName(p.getPrivilegeName());
    dto.setPrivilegeModuleName(p.getPrivilegeModuleName());
    dto.setPrivilegeDescription(p.getPrivilegeDescription());
    dto.setPrivilegeStatus(p.getPrivilegeStatus());
    dto.setPrivilegeCreatedAt(p.getPrivilegeCreatedAt());
    dto.setPrivilegeUpdatedAt(p.getPrivilegeUpdatedAt());
    return dto;
   }
}
