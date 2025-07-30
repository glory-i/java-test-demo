
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
public class PrivilegeRepositoryImpl implements PrivilegeRepository {

    private final Environment environment;

    @Autowired
    public PrivilegeRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Privilege  privilege) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int privilegeId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), PrivilegeQuery.INSERT, true)
                .bind (privilege)
                .executeUpdate()
                .getKey(int.class);


        return privilegeId;
    }

    @Override
    public void bulkCreate(List<Privilege> privileges) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,PrivilegeQuery.INSERT, false);
            for (Privilege privilege : privileges) {
                query.bind(privilege).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Privilege privilege) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.UPDATE, true)
                .bind (privilege)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int privilegeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.DELETE, true)
                .addParameter("privilegeId", privilegeId)
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
                    .execute(PrivilegeQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Privilege> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ, true)
                .executeAndFetch(Privilege.class);
    }
    @Override
    public Privilege readByPrivilegeId(int privilegeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ_BY_PRIVILEGE_PRIVILEGEID, true)
                .addParameter("privilegeId", privilegeId)
                .executeAndFetch (Privilege.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Privilege> readByPrivilegeCode(String privilegeCode) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ_BY_PRIVILEGE_PRIVILEGECODE, true)
                .addParameter("privilegeCode", privilegeCode)
                .executeAndFetch(Privilege.class);
    }
    @Override
    public List<Privilege> readByPrivilegeName(String privilegeName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ_BY_PRIVILEGE_PRIVILEGENAME, true)
                .addParameter("privilegeName", privilegeName)
                .executeAndFetch(Privilege.class);
    }
    @Override
    public List<Privilege> readByPrivilegeModuleName(String privilegeModuleName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ_BY_PRIVILEGE_PRIVILEGEMODULENAME, true)
                .addParameter("privilegeModuleName", privilegeModuleName)
                .executeAndFetch(Privilege.class);
    }
    @Override
    public List<Privilege> readByPrivilegeDescription(String privilegeDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ_BY_PRIVILEGE_PRIVILEGEDESCRIPTION, true)
                .addParameter("privilegeDescription", privilegeDescription)
                .executeAndFetch(Privilege.class);
    }
    @Override
    public List<Privilege> readByPrivilegeStatus(String privilegeStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ_BY_PRIVILEGE_PRIVILEGESTATUS, true)
                .addParameter("privilegeStatus", privilegeStatus)
                .executeAndFetch(Privilege.class);
    }
    @Override
    public List<Privilege> readByPrivilegeCreatedAt(String privilegeCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ_BY_PRIVILEGE_PRIVILEGECREATEDAT, true)
                .addParameter("privilegeCreatedAt", privilegeCreatedAt)
                .executeAndFetch(Privilege.class);
    }
    @Override
    public List<Privilege> readByPrivilegeUpdatedAt(String privilegeUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PrivilegeQuery.READ_BY_PRIVILEGE_PRIVILEGEUPDATEDAT, true)
                .addParameter("privilegeUpdatedAt", privilegeUpdatedAt)
                .executeAndFetch(Privilege.class);
    }

@Override
public PrivilegePage findPrivilege(PrivilegeFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(PrivilegeQuery.READ);

    // Dynamic filters

    if (filter.getPrivilegeId() != null) {   baseSql.append(" AND privilegeId = :privilegeId"); }
    if (filter.getPrivilegeCode() != null) {   baseSql.append(" AND privilegeCode = :privilegeCode"); }
    if (filter.getPrivilegeName() != null) {   baseSql.append(" AND privilegeName = :privilegeName"); }
    if (filter.getPrivilegeModuleName() != null) {   baseSql.append(" AND privilegeModuleName = :privilegeModuleName"); }
    if (filter.getPrivilegeDescription() != null) {   baseSql.append(" AND privilegeDescription = :privilegeDescription"); }
    if (filter.getPrivilegeStatus() != null) {   baseSql.append(" AND privilegeStatus = :privilegeStatus"); }
    if (filter.getPrivilegeCreatedAt() != null) {   baseSql.append(" AND privilegeCreatedAt = :privilegeCreatedAt"); }
    if (filter.getPrivilegeUpdatedAt() != null) {   baseSql.append(" AND privilegeUpdatedAt = :privilegeUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getPrivilegeId() != null) countQuery.addParameter("privilegeId", filter.getPrivilegeId());
     if (filter.getPrivilegeCode() != null) countQuery.addParameter("privilegeCode", filter.getPrivilegeCode());
     if (filter.getPrivilegeName() != null) countQuery.addParameter("privilegeName", filter.getPrivilegeName());
     if (filter.getPrivilegeModuleName() != null) countQuery.addParameter("privilegeModuleName", filter.getPrivilegeModuleName());
     if (filter.getPrivilegeDescription() != null) countQuery.addParameter("privilegeDescription", filter.getPrivilegeDescription());
     if (filter.getPrivilegeStatus() != null) countQuery.addParameter("privilegeStatus", filter.getPrivilegeStatus());
     if (filter.getPrivilegeCreatedAt() != null) countQuery.addParameter("privilegeCreatedAt", filter.getPrivilegeCreatedAt());
     if (filter.getPrivilegeUpdatedAt() != null) countQuery.addParameter("privilegeUpdatedAt", filter.getPrivilegeUpdatedAt());
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

    if (filter.getPrivilegeId() != null) pageQuery.addParameter("privilegeId", filter.getPrivilegeId());
    if (filter.getPrivilegeCode() != null) pageQuery.addParameter("privilegeCode", filter.getPrivilegeCode());
    if (filter.getPrivilegeName() != null) pageQuery.addParameter("privilegeName", filter.getPrivilegeName());
    if (filter.getPrivilegeModuleName() != null) pageQuery.addParameter("privilegeModuleName", filter.getPrivilegeModuleName());
    if (filter.getPrivilegeDescription() != null) pageQuery.addParameter("privilegeDescription", filter.getPrivilegeDescription());
    if (filter.getPrivilegeStatus() != null) pageQuery.addParameter("privilegeStatus", filter.getPrivilegeStatus());
    if (filter.getPrivilegeCreatedAt() != null) pageQuery.addParameter("privilegeCreatedAt", filter.getPrivilegeCreatedAt());
    if (filter.getPrivilegeUpdatedAt() != null) pageQuery.addParameter("privilegeUpdatedAt", filter.getPrivilegeUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Privilege> data = pageQuery.executeAndFetch(Privilege.class);

     return new PrivilegePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "privilegeId","privilegeCode","privilegeName","privilegeModuleName","privilegeDescription","privilegeStatus","privilegeCreatedAt","privilegeUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
