
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.ModulePage;
import qucoon.mod.SpringServerless.model.request.ModuleFilterRequest;

import java.util.List;

@Repository
    public interface ModuleRepository {


    // Additional query methods can be defined here.
    int create(Module module);
    void bulkCreate(List<Module>  module);
    int update(Module  module);
    int delete(int moduleId);
    ModulePage findModule(ModuleFilterRequest filter);
    boolean truncate();
    List<Module> read();
    Module readByModuleId(int moduleId);
    List<Module> readByModuleName(String moduleName);
    List<Module> readByModuleDescription(String moduleDescription);
    List<Module> readByModuleStatus(String moduleStatus);
    List<Module> readByModuleCreatedAt(String moduleCreatedAt);
    List<Module> readByModuleUpdatedAt(String moduleUpdatedAt);
}
