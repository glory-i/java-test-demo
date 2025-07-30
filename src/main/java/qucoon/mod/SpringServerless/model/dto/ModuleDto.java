package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Module;


@Data
public class ModuleDto  {

private Integer moduleId;
private String moduleName;
private String moduleDescription;
private String moduleStatus;
private String moduleCreatedAt;
private String moduleUpdatedAt;

public static ModuleDto from(Module p) {
    ModuleDto dto = new ModuleDto();

    dto.setModuleId(p.getModuleId());
    dto.setModuleName(p.getModuleName());
    dto.setModuleDescription(p.getModuleDescription());
    dto.setModuleStatus(p.getModuleStatus());
    dto.setModuleCreatedAt(p.getModuleCreatedAt());
    dto.setModuleUpdatedAt(p.getModuleUpdatedAt());
    return dto;
   }
}
