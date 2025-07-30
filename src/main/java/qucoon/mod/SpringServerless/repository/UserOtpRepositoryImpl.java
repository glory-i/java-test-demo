
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
public class UserOtpRepositoryImpl implements UserOtpRepository {

    private final Environment environment;

    @Autowired
    public UserOtpRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(UserOtp  userotp) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int userOtpId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), UserOtpQuery.INSERT, true)
                .bind (userotp)
                .executeUpdate()
                .getKey(int.class);


        return userOtpId;
    }

    @Override
    public void bulkCreate(List<UserOtp> userotps) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,UserOtpQuery.INSERT, false);
            for (UserOtp userotp : userotps) {
                query.bind(userotp).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(UserOtp userotp) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.UPDATE, true)
                .bind (userotp)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int userOtpId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.DELETE, true)
                .addParameter("userOtpId", userOtpId)
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
                    .execute(UserOtpQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserOtp> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.READ, true)
                .executeAndFetch(UserOtp.class);
    }
    @Override
    public UserOtp readByUserOtpId(int userOtpId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.READ_BY_USER_OTP_USEROTPID, true)
                .addParameter("userOtpId", userOtpId)
                .executeAndFetch (UserOtp.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<UserOtp> readByUserOtpUsername(String userOtpUsername) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.READ_BY_USER_OTP_USEROTPUSERNAME, true)
                .addParameter("userOtpUsername", userOtpUsername)
                .executeAndFetch(UserOtp.class);
    }
    @Override
    public List<UserOtp> readByUserOtpOtp(String userOtpOtp) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.READ_BY_USER_OTP_USEROTPOTP, true)
                .addParameter("userOtpOtp", userOtpOtp)
                .executeAndFetch(UserOtp.class);
    }
    @Override
    public List<UserOtp> readByUserOtpStatus(String userOtpStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.READ_BY_USER_OTP_USEROTPSTATUS, true)
                .addParameter("userOtpStatus", userOtpStatus)
                .executeAndFetch(UserOtp.class);
    }
    @Override
    public List<UserOtp> readByUserOtpCreatedAt(String userOtpCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.READ_BY_USER_OTP_USEROTPCREATEDAT, true)
                .addParameter("userOtpCreatedAt", userOtpCreatedAt)
                .executeAndFetch(UserOtp.class);
    }
    @Override
    public List<UserOtp> readByUserOtpUpdatedAt(String userOtpUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserOtpQuery.READ_BY_USER_OTP_USEROTPUPDATEDAT, true)
                .addParameter("userOtpUpdatedAt", userOtpUpdatedAt)
                .executeAndFetch(UserOtp.class);
    }

@Override
public UserOtpPage findUserOtp(UserOtpFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(UserOtpQuery.READ);

    // Dynamic filters

    if (filter.getUserOtpId() != null) {   baseSql.append(" AND userOtpId = :userOtpId"); }
    if (filter.getUserOtpUsername() != null) {   baseSql.append(" AND userOtpUsername = :userOtpUsername"); }
    if (filter.getUserOtpOtp() != null) {   baseSql.append(" AND userOtpOtp = :userOtpOtp"); }
    if (filter.getUserOtpStatus() != null) {   baseSql.append(" AND userOtpStatus = :userOtpStatus"); }
    if (filter.getUserOtpCreatedAt() != null) {   baseSql.append(" AND userOtpCreatedAt = :userOtpCreatedAt"); }
    if (filter.getUserOtpUpdatedAt() != null) {   baseSql.append(" AND userOtpUpdatedAt = :userOtpUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getUserOtpId() != null) countQuery.addParameter("userOtpId", filter.getUserOtpId());
     if (filter.getUserOtpUsername() != null) countQuery.addParameter("userOtpUsername", filter.getUserOtpUsername());
     if (filter.getUserOtpOtp() != null) countQuery.addParameter("userOtpOtp", filter.getUserOtpOtp());
     if (filter.getUserOtpStatus() != null) countQuery.addParameter("userOtpStatus", filter.getUserOtpStatus());
     if (filter.getUserOtpCreatedAt() != null) countQuery.addParameter("userOtpCreatedAt", filter.getUserOtpCreatedAt());
     if (filter.getUserOtpUpdatedAt() != null) countQuery.addParameter("userOtpUpdatedAt", filter.getUserOtpUpdatedAt());
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

    if (filter.getUserOtpId() != null) pageQuery.addParameter("userOtpId", filter.getUserOtpId());
    if (filter.getUserOtpUsername() != null) pageQuery.addParameter("userOtpUsername", filter.getUserOtpUsername());
    if (filter.getUserOtpOtp() != null) pageQuery.addParameter("userOtpOtp", filter.getUserOtpOtp());
    if (filter.getUserOtpStatus() != null) pageQuery.addParameter("userOtpStatus", filter.getUserOtpStatus());
    if (filter.getUserOtpCreatedAt() != null) pageQuery.addParameter("userOtpCreatedAt", filter.getUserOtpCreatedAt());
    if (filter.getUserOtpUpdatedAt() != null) pageQuery.addParameter("userOtpUpdatedAt", filter.getUserOtpUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<UserOtp> data = pageQuery.executeAndFetch(UserOtp.class);

     return new UserOtpPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "userOtpId","userOtpUsername","userOtpOtp","userOtpStatus","userOtpCreatedAt","userOtpUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
