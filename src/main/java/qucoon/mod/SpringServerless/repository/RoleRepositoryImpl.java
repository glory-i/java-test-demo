
package   qucoon.mod.SpringServerless.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.repository.query.*;
import qucoon.mod.SpringServerless.utility.Environment;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.repository.page.*;
import qucoon.mod.SpringServerless.model.entity.Module;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.List;

import static qucoon.mod.SpringServerless.repository.query.QueryUtils.createQueryWithoutOnMappingFailure;


@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final Environment environment;

    @Autowired
    public RoleRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Role  role) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int rolePrivilegeId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), RoleQuery.INSERT, true)
                .bind (role)
                .executeUpdate()
                .getKey(int.class);


        return rolePrivilegeId;
    }

    @Override
    public void bulkCreate(List<Role> roles) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,RoleQuery.INSERT, false);
            for (Role role : roles) {
                query.bind(role).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Role role) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.UPDATE, true)
                .bind (role)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int rolePrivilegeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.DELETE, true)
                .addParameter("rolePrivilegeId", rolePrivilegeId)
                .executeUpdate()
                .getResult();
    }

    @Override
    public boolean truncate() {
        try {
            assert environment.getDatabaseUtil().getSql2oConnection() != null;
            return environment.getDatabaseUtil().getSql2oConnection()
                    .getJdbcConnection()
                    .createStatement()
                    .execute(RoleQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Role> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ, true)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRoleId(int roleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEID, true)
                .addParameter("roleId", roleId)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRoleName(String roleName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLENAME, true)
                .addParameter("roleName", roleName)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRoleDescription(String roleDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEDESCRIPTION, true)
                .addParameter("roleDescription", roleDescription)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRoleIsPublic(String roleIsPublic) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEISPUBLIC, true)
                .addParameter("roleIsPublic", roleIsPublic)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRoleStatus(String roleStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLESTATUS, true)
                .addParameter("roleStatus", roleStatus)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRoleCreatedAt(String roleCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLECREATEDAT, true)
                .addParameter("roleCreatedAt", roleCreatedAt)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRoleUpdatedAt(String roleUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEUPDATEDAT, true)
                .addParameter("roleUpdatedAt", roleUpdatedAt)
                .executeAndFetch(Role.class);
    }
    @Override
    public Role readByRolePrivilegeId(int rolePrivilegeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEPRIVILEGEID, true)
                .addParameter("rolePrivilegeId", rolePrivilegeId)
                .executeAndFetch (Role.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Role> readByRolePrivilegeRoleId(int rolePrivilegeRoleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEPRIVILEGEROLEID, true)
                .addParameter("rolePrivilegeRoleId", rolePrivilegeRoleId)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRolePrivilegePrivilegeCode(String rolePrivilegePrivilegeCode) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEPRIVILEGEPRIVILEGECODE, true)
                .addParameter("rolePrivilegePrivilegeCode", rolePrivilegePrivilegeCode)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRolePrivilegeStatus(String rolePrivilegeStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEPRIVILEGESTATUS, true)
                .addParameter("rolePrivilegeStatus", rolePrivilegeStatus)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRolePrivilegeCreatedAt(String rolePrivilegeCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEPRIVILEGECREATEDAT, true)
                .addParameter("rolePrivilegeCreatedAt", rolePrivilegeCreatedAt)
                .executeAndFetch(Role.class);
    }
    @Override
    public List<Role> readByRolePrivilegeUpdatedAt(String rolePrivilegeUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RoleQuery.READ_BY_ROLE_ROLEPRIVILEGEUPDATEDAT, true)
                .addParameter("rolePrivilegeUpdatedAt", rolePrivilegeUpdatedAt)
                .executeAndFetch(Role.class);
    }

@Override
public RolePage findRole(RoleFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(RoleQuery.READ);

    // Dynamic filters

    if (filter.getRoleId() != null) {   baseSql.append(" AND roleId = :roleId"); }
    if (filter.getRoleName() != null) {   baseSql.append(" AND roleName = :roleName"); }
    if (filter.getRoleDescription() != null) {   baseSql.append(" AND roleDescription = :roleDescription"); }
    if (filter.getRoleIsPublic() != null) {   baseSql.append(" AND roleIsPublic = :roleIsPublic"); }
    if (filter.getRoleStatus() != null) {   baseSql.append(" AND roleStatus = :roleStatus"); }
    if (filter.getRoleCreatedAt() != null) {   baseSql.append(" AND roleCreatedAt = :roleCreatedAt"); }
    if (filter.getRoleUpdatedAt() != null) {   baseSql.append(" AND roleUpdatedAt = :roleUpdatedAt"); }
    if (filter.getRolePrivilegeId() != null) {   baseSql.append(" AND rolePrivilegeId = :rolePrivilegeId"); }
    if (filter.getRolePrivilegeRoleId() != null) {   baseSql.append(" AND rolePrivilegeRoleId = :rolePrivilegeRoleId"); }
    if (filter.getRolePrivilegePrivilegeCode() != null) {   baseSql.append(" AND rolePrivilegePrivilegeCode = :rolePrivilegePrivilegeCode"); }
    if (filter.getRolePrivilegeStatus() != null) {   baseSql.append(" AND rolePrivilegeStatus = :rolePrivilegeStatus"); }
    if (filter.getRolePrivilegeCreatedAt() != null) {   baseSql.append(" AND rolePrivilegeCreatedAt = :rolePrivilegeCreatedAt"); }
    if (filter.getRolePrivilegeUpdatedAt() != null) {   baseSql.append(" AND rolePrivilegeUpdatedAt = :rolePrivilegeUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getRoleId() != null) countQuery.addParameter("roleId", filter.getRoleId());
     if (filter.getRoleName() != null) countQuery.addParameter("roleName", filter.getRoleName());
     if (filter.getRoleDescription() != null) countQuery.addParameter("roleDescription", filter.getRoleDescription());
     if (filter.getRoleIsPublic() != null) countQuery.addParameter("roleIsPublic", filter.getRoleIsPublic());
     if (filter.getRoleStatus() != null) countQuery.addParameter("roleStatus", filter.getRoleStatus());
     if (filter.getRoleCreatedAt() != null) countQuery.addParameter("roleCreatedAt", filter.getRoleCreatedAt());
     if (filter.getRoleUpdatedAt() != null) countQuery.addParameter("roleUpdatedAt", filter.getRoleUpdatedAt());
     if (filter.getRolePrivilegeId() != null) countQuery.addParameter("rolePrivilegeId", filter.getRolePrivilegeId());
     if (filter.getRolePrivilegeRoleId() != null) countQuery.addParameter("rolePrivilegeRoleId", filter.getRolePrivilegeRoleId());
     if (filter.getRolePrivilegePrivilegeCode() != null) countQuery.addParameter("rolePrivilegePrivilegeCode", filter.getRolePrivilegePrivilegeCode());
     if (filter.getRolePrivilegeStatus() != null) countQuery.addParameter("rolePrivilegeStatus", filter.getRolePrivilegeStatus());
     if (filter.getRolePrivilegeCreatedAt() != null) countQuery.addParameter("rolePrivilegeCreatedAt", filter.getRolePrivilegeCreatedAt());
     if (filter.getRolePrivilegeUpdatedAt() != null) countQuery.addParameter("rolePrivilegeUpdatedAt", filter.getRolePrivilegeUpdatedAt());
     if (filter.getSearch() != null) countQuery.addParameter("search", "%" + filter.getSearch() + "%");
     Long total = countQuery.executeScalar(Long.class);

   // MSSQL pagination requires ORDER BY for OFFSET/FETCH
    String validSortDir = filter.getSortDir().equalsIgnoreCase("ASC") ? "ASC" : "DESC";
    String orderBy = " ORDER BY " + sanitizeSortBy(filter.getSortBy()) + " " + validSortDir;
     // Append order and pagination
     StringBuilder pageSql_old = new StringBuilder(baseSql)
             .append(" ORDER BY ").append (filter.getSortBy())
             .append(" ").append (filter.getSortDir())
             .append(" LIMIT :limit OFFSET :offset");
    // Build pagination SQL
    String pageSql = baseSql.toString() + orderBy +
" LIMIT :limit OFFSET :offset ";

     // Fetch page data
     var pageQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             pageSql.toString(),
             true);

    if (filter.getRoleId() != null) pageQuery.addParameter("roleId", filter.getRoleId());
    if (filter.getRoleName() != null) pageQuery.addParameter("roleName", filter.getRoleName());
    if (filter.getRoleDescription() != null) pageQuery.addParameter("roleDescription", filter.getRoleDescription());
    if (filter.getRoleIsPublic() != null) pageQuery.addParameter("roleIsPublic", filter.getRoleIsPublic());
    if (filter.getRoleStatus() != null) pageQuery.addParameter("roleStatus", filter.getRoleStatus());
    if (filter.getRoleCreatedAt() != null) pageQuery.addParameter("roleCreatedAt", filter.getRoleCreatedAt());
    if (filter.getRoleUpdatedAt() != null) pageQuery.addParameter("roleUpdatedAt", filter.getRoleUpdatedAt());
    if (filter.getRolePrivilegeId() != null) pageQuery.addParameter("rolePrivilegeId", filter.getRolePrivilegeId());
    if (filter.getRolePrivilegeRoleId() != null) pageQuery.addParameter("rolePrivilegeRoleId", filter.getRolePrivilegeRoleId());
    if (filter.getRolePrivilegePrivilegeCode() != null) pageQuery.addParameter("rolePrivilegePrivilegeCode", filter.getRolePrivilegePrivilegeCode());
    if (filter.getRolePrivilegeStatus() != null) pageQuery.addParameter("rolePrivilegeStatus", filter.getRolePrivilegeStatus());
    if (filter.getRolePrivilegeCreatedAt() != null) pageQuery.addParameter("rolePrivilegeCreatedAt", filter.getRolePrivilegeCreatedAt());
    if (filter.getRolePrivilegeUpdatedAt() != null) pageQuery.addParameter("rolePrivilegeUpdatedAt", filter.getRolePrivilegeUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Role> data = pageQuery.executeAndFetch(Role.class);

     return new RolePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "roleId","roleName","roleDescription","roleIsPublic","roleStatus","roleCreatedAt","roleUpdatedAt","rolePrivilegeId","rolePrivilegeRoleId","rolePrivilegePrivilegeCode","rolePrivilegeStatus","rolePrivilegeCreatedAt","rolePrivilegeUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
