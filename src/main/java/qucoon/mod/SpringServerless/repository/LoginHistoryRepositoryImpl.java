
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
public class LoginHistoryRepositoryImpl implements LoginHistoryRepository {

    private final Environment environment;

    @Autowired
    public LoginHistoryRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(LoginHistory  loginhistory) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int loginHistoryId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), LoginHistoryQuery.INSERT, true)
                .bind (loginhistory)
                .executeUpdate()
                .getKey(int.class);


        return loginHistoryId;
    }

    @Override
    public void bulkCreate(List<LoginHistory> loginhistorys) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,LoginHistoryQuery.INSERT, false);
            for (LoginHistory loginhistory : loginhistorys) {
                query.bind(loginhistory).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(LoginHistory loginhistory) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.UPDATE, true)
                .bind (loginhistory)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int loginHistoryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.DELETE, true)
                .addParameter("loginHistoryId", loginHistoryId)
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
                    .execute(LoginHistoryQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<LoginHistory> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ, true)
                .executeAndFetch(LoginHistory.class);
    }
    @Override
    public LoginHistory readByLoginHistoryId(int loginHistoryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYID, true)
                .addParameter("loginHistoryId", loginHistoryId)
                .executeAndFetch (LoginHistory.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<LoginHistory> readByLoginHistoryUsername(String loginHistoryUsername) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYUSERNAME, true)
                .addParameter("loginHistoryUsername", loginHistoryUsername)
                .executeAndFetch(LoginHistory.class);
    }
    @Override
    public List<LoginHistory> readByLoginHistoryIpAddress(String loginHistoryIpAddress) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYIPADDRESS, true)
                .addParameter("loginHistoryIpAddress", loginHistoryIpAddress)
                .executeAndFetch(LoginHistory.class);
    }
    @Override
    public List<LoginHistory> readByLoginHistoryDeviceId(String loginHistoryDeviceId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYDEVICEID, true)
                .addParameter("loginHistoryDeviceId", loginHistoryDeviceId)
                .executeAndFetch(LoginHistory.class);
    }
    @Override
    public List<LoginHistory> readByLoginHistoryLongitude(String loginHistoryLongitude) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYLONGITUDE, true)
                .addParameter("loginHistoryLongitude", loginHistoryLongitude)
                .executeAndFetch(LoginHistory.class);
    }
    @Override
    public List<LoginHistory> readByLoginHistoryLatitude(String loginHistoryLatitude) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYLATITUDE, true)
                .addParameter("loginHistoryLatitude", loginHistoryLatitude)
                .executeAndFetch(LoginHistory.class);
    }
    @Override
    public List<LoginHistory> readByLoginHistoryStatus(String loginHistoryStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYSTATUS, true)
                .addParameter("loginHistoryStatus", loginHistoryStatus)
                .executeAndFetch(LoginHistory.class);
    }
    @Override
    public List<LoginHistory> readByLoginHistoryCreatedAt(String loginHistoryCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYCREATEDAT, true)
                .addParameter("loginHistoryCreatedAt", loginHistoryCreatedAt)
                .executeAndFetch(LoginHistory.class);
    }
    @Override
    public List<LoginHistory> readByLoginHistoryUpdatedAt(String loginHistoryUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LoginHistoryQuery.READ_BY_LOGIN_HISTORY_LOGINHISTORYUPDATEDAT, true)
                .addParameter("loginHistoryUpdatedAt", loginHistoryUpdatedAt)
                .executeAndFetch(LoginHistory.class);
    }

@Override
public LoginHistoryPage findLoginHistory(LoginHistoryFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(LoginHistoryQuery.READ);

    // Dynamic filters

    if (filter.getLoginHistoryId() != null) {   baseSql.append(" AND loginHistoryId = :loginHistoryId"); }
    if (filter.getLoginHistoryUsername() != null) {   baseSql.append(" AND loginHistoryUsername = :loginHistoryUsername"); }
    if (filter.getLoginHistoryIpAddress() != null) {   baseSql.append(" AND loginHistoryIpAddress = :loginHistoryIpAddress"); }
    if (filter.getLoginHistoryDeviceId() != null) {   baseSql.append(" AND loginHistoryDeviceId = :loginHistoryDeviceId"); }
    if (filter.getLoginHistoryLongitude() != null) {   baseSql.append(" AND loginHistoryLongitude = :loginHistoryLongitude"); }
    if (filter.getLoginHistoryLatitude() != null) {   baseSql.append(" AND loginHistoryLatitude = :loginHistoryLatitude"); }
    if (filter.getLoginHistoryStatus() != null) {   baseSql.append(" AND loginHistoryStatus = :loginHistoryStatus"); }
    if (filter.getLoginHistoryCreatedAt() != null) {   baseSql.append(" AND loginHistoryCreatedAt = :loginHistoryCreatedAt"); }
    if (filter.getLoginHistoryUpdatedAt() != null) {   baseSql.append(" AND loginHistoryUpdatedAt = :loginHistoryUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getLoginHistoryId() != null) countQuery.addParameter("loginHistoryId", filter.getLoginHistoryId());
     if (filter.getLoginHistoryUsername() != null) countQuery.addParameter("loginHistoryUsername", filter.getLoginHistoryUsername());
     if (filter.getLoginHistoryIpAddress() != null) countQuery.addParameter("loginHistoryIpAddress", filter.getLoginHistoryIpAddress());
     if (filter.getLoginHistoryDeviceId() != null) countQuery.addParameter("loginHistoryDeviceId", filter.getLoginHistoryDeviceId());
     if (filter.getLoginHistoryLongitude() != null) countQuery.addParameter("loginHistoryLongitude", filter.getLoginHistoryLongitude());
     if (filter.getLoginHistoryLatitude() != null) countQuery.addParameter("loginHistoryLatitude", filter.getLoginHistoryLatitude());
     if (filter.getLoginHistoryStatus() != null) countQuery.addParameter("loginHistoryStatus", filter.getLoginHistoryStatus());
     if (filter.getLoginHistoryCreatedAt() != null) countQuery.addParameter("loginHistoryCreatedAt", filter.getLoginHistoryCreatedAt());
     if (filter.getLoginHistoryUpdatedAt() != null) countQuery.addParameter("loginHistoryUpdatedAt", filter.getLoginHistoryUpdatedAt());
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

    if (filter.getLoginHistoryId() != null) pageQuery.addParameter("loginHistoryId", filter.getLoginHistoryId());
    if (filter.getLoginHistoryUsername() != null) pageQuery.addParameter("loginHistoryUsername", filter.getLoginHistoryUsername());
    if (filter.getLoginHistoryIpAddress() != null) pageQuery.addParameter("loginHistoryIpAddress", filter.getLoginHistoryIpAddress());
    if (filter.getLoginHistoryDeviceId() != null) pageQuery.addParameter("loginHistoryDeviceId", filter.getLoginHistoryDeviceId());
    if (filter.getLoginHistoryLongitude() != null) pageQuery.addParameter("loginHistoryLongitude", filter.getLoginHistoryLongitude());
    if (filter.getLoginHistoryLatitude() != null) pageQuery.addParameter("loginHistoryLatitude", filter.getLoginHistoryLatitude());
    if (filter.getLoginHistoryStatus() != null) pageQuery.addParameter("loginHistoryStatus", filter.getLoginHistoryStatus());
    if (filter.getLoginHistoryCreatedAt() != null) pageQuery.addParameter("loginHistoryCreatedAt", filter.getLoginHistoryCreatedAt());
    if (filter.getLoginHistoryUpdatedAt() != null) pageQuery.addParameter("loginHistoryUpdatedAt", filter.getLoginHistoryUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<LoginHistory> data = pageQuery.executeAndFetch(LoginHistory.class);

     return new LoginHistoryPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "loginHistoryId","loginHistoryUsername","loginHistoryIpAddress","loginHistoryDeviceId","loginHistoryLongitude","loginHistoryLatitude","loginHistoryStatus","loginHistoryCreatedAt","loginHistoryUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
