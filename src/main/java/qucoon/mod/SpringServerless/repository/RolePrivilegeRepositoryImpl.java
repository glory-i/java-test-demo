
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
public class RolePrivilegeRepositoryImpl implements RolePrivilegeRepository {

    private final Environment environment;

    @Autowired
    public RolePrivilegeRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(RolePrivilege  roleprivilege) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int rolePrivilegeId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), RolePrivilegeQuery.INSERT, true)
                .bind (roleprivilege)
                .executeUpdate()
                .getKey(int.class);


        return rolePrivilegeId;
    }

    @Override
    public void bulkCreate(List<RolePrivilege> roleprivileges) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,RolePrivilegeQuery.INSERT, false);
            for (RolePrivilege roleprivilege : roleprivileges) {
                query.bind(roleprivilege).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(RolePrivilege roleprivilege) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.UPDATE, true)
                .bind (roleprivilege)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int rolePrivilegeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.DELETE, true)
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
                    .execute(RolePrivilegeQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<RolePrivilege> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.READ, true)
                .executeAndFetch(RolePrivilege.class);
    }
    @Override
    public RolePrivilege readByRolePrivilegeId(int rolePrivilegeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGEID, true)
                .addParameter("rolePrivilegeId", rolePrivilegeId)
                .executeAndFetch (RolePrivilege.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<RolePrivilege> readByRolePrivilegeRoleId(int rolePrivilegeRoleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGEROLEID, true)
                .addParameter("rolePrivilegeRoleId", rolePrivilegeRoleId)
                .executeAndFetch(RolePrivilege.class);
    }
    @Override
    public List<RolePrivilege> readByRolePrivilegePrivilegeCode(String rolePrivilegePrivilegeCode) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGEPRIVILEGECODE, true)
                .addParameter("rolePrivilegePrivilegeCode", rolePrivilegePrivilegeCode)
                .executeAndFetch(RolePrivilege.class);
    }
    @Override
    public List<RolePrivilege> readByRolePrivilegeStatus(String rolePrivilegeStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGESTATUS, true)
                .addParameter("rolePrivilegeStatus", rolePrivilegeStatus)
                .executeAndFetch(RolePrivilege.class);
    }
    @Override
    public List<RolePrivilege> readByRolePrivilegeCreatedAt(String rolePrivilegeCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGECREATEDAT, true)
                .addParameter("rolePrivilegeCreatedAt", rolePrivilegeCreatedAt)
                .executeAndFetch(RolePrivilege.class);
    }
    @Override
    public List<RolePrivilege> readByRolePrivilegeUpdatedAt(String rolePrivilegeUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),RolePrivilegeQuery.READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGEUPDATEDAT, true)
                .addParameter("rolePrivilegeUpdatedAt", rolePrivilegeUpdatedAt)
                .executeAndFetch(RolePrivilege.class);
    }

@Override
public RolePrivilegePage findRolePrivilege(RolePrivilegeFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(RolePrivilegeQuery.READ);

    // Dynamic filters

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

    if (filter.getRolePrivilegeId() != null) pageQuery.addParameter("rolePrivilegeId", filter.getRolePrivilegeId());
    if (filter.getRolePrivilegeRoleId() != null) pageQuery.addParameter("rolePrivilegeRoleId", filter.getRolePrivilegeRoleId());
    if (filter.getRolePrivilegePrivilegeCode() != null) pageQuery.addParameter("rolePrivilegePrivilegeCode", filter.getRolePrivilegePrivilegeCode());
    if (filter.getRolePrivilegeStatus() != null) pageQuery.addParameter("rolePrivilegeStatus", filter.getRolePrivilegeStatus());
    if (filter.getRolePrivilegeCreatedAt() != null) pageQuery.addParameter("rolePrivilegeCreatedAt", filter.getRolePrivilegeCreatedAt());
    if (filter.getRolePrivilegeUpdatedAt() != null) pageQuery.addParameter("rolePrivilegeUpdatedAt", filter.getRolePrivilegeUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<RolePrivilege> data = pageQuery.executeAndFetch(RolePrivilege.class);

     return new RolePrivilegePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "rolePrivilegeId","rolePrivilegeRoleId","rolePrivilegePrivilegeCode","rolePrivilegeStatus","rolePrivilegeCreatedAt","rolePrivilegeUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
