
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.PrivilegePage;
import qucoon.mod.SpringServerless.model.request.PrivilegeFilterRequest;

import java.util.List;

@Repository
    public interface PrivilegeRepository {


    // Additional query methods can be defined here.
    int create(Privilege privilege);
    void bulkCreate(List<Privilege>  privilege);
    int update(Privilege  privilege);
    int delete(int privilegeId);
    PrivilegePage findPrivilege(PrivilegeFilterRequest filter);
    boolean truncate();
    List<Privilege> read();
    Privilege readByPrivilegeId(int privilegeId);
    List<Privilege> readByPrivilegeCode(String privilegeCode);
    List<Privilege> readByPrivilegeName(String privilegeName);
    List<Privilege> readByPrivilegeModuleName(String privilegeModuleName);
    List<Privilege> readByPrivilegeDescription(String privilegeDescription);
    List<Privilege> readByPrivilegeStatus(String privilegeStatus);
    List<Privilege> readByPrivilegeCreatedAt(String privilegeCreatedAt);
    List<Privilege> readByPrivilegeUpdatedAt(String privilegeUpdatedAt);
}
