
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.RolePrivilegePage;
import qucoon.mod.SpringServerless.model.request.RolePrivilegeFilterRequest;

import java.util.List;

@Repository
    public interface RolePrivilegeRepository {


    // Additional query methods can be defined here.
    int create(RolePrivilege roleprivilege);
    void bulkCreate(List<RolePrivilege>  roleprivilege);
    int update(RolePrivilege  roleprivilege);
    int delete(int rolePrivilegeId);
    RolePrivilegePage findRolePrivilege(RolePrivilegeFilterRequest filter);
    boolean truncate();
    List<RolePrivilege> read();
    RolePrivilege readByRolePrivilegeId(int rolePrivilegeId);
    List<RolePrivilege> readByRolePrivilegeRoleId(int rolePrivilegeRoleId);
    List<RolePrivilege> readByRolePrivilegePrivilegeCode(String rolePrivilegePrivilegeCode);
    List<RolePrivilege> readByRolePrivilegeStatus(String rolePrivilegeStatus);
    List<RolePrivilege> readByRolePrivilegeCreatedAt(String rolePrivilegeCreatedAt);
    List<RolePrivilege> readByRolePrivilegeUpdatedAt(String rolePrivilegeUpdatedAt);
}
