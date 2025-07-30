
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
public class AuditLogRepositoryImpl implements AuditLogRepository {

    private final Environment environment;

    @Autowired
    public AuditLogRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(AuditLog  auditlog) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int auditLogId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), AuditLogQuery.INSERT, true)
                .bind (auditlog)
                .executeUpdate()
                .getKey(int.class);


        return auditLogId;
    }

    @Override
    public void bulkCreate(List<AuditLog> auditlogs) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,AuditLogQuery.INSERT, false);
            for (AuditLog auditlog : auditlogs) {
                query.bind(auditlog).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(AuditLog auditlog) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.UPDATE, true)
                .bind (auditlog)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int auditLogId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.DELETE, true)
                .addParameter("auditLogId", auditLogId)
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
                    .execute(AuditLogQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<AuditLog> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ, true)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public AuditLog readByAuditLogId(int auditLogId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGID, true)
                .addParameter("auditLogId", auditLogId)
                .executeAndFetch (AuditLog.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<AuditLog> readByAuditLogUserId(int auditLogUserId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGUSERID, true)
                .addParameter("auditLogUserId", auditLogUserId)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogAction(String auditLogAction) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGACTION, true)
                .addParameter("auditLogAction", auditLogAction)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogRequest(String auditLogRequest) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGREQUEST, true)
                .addParameter("auditLogRequest", auditLogRequest)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogResponse(String auditLogResponse) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGRESPONSE, true)
                .addParameter("auditLogResponse", auditLogResponse)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogModule(String auditLogModule) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGMODULE, true)
                .addParameter("auditLogModule", auditLogModule)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogResponseCode(String auditLogResponseCode) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGRESPONSECODE, true)
                .addParameter("auditLogResponseCode", auditLogResponseCode)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogResponseMessage(String auditLogResponseMessage) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGRESPONSEMESSAGE, true)
                .addParameter("auditLogResponseMessage", auditLogResponseMessage)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogStatus(String auditLogStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGSTATUS, true)
                .addParameter("auditLogStatus", auditLogStatus)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogCreatedAt(String auditLogCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGCREATEDAT, true)
                .addParameter("auditLogCreatedAt", auditLogCreatedAt)
                .executeAndFetch(AuditLog.class);
    }
    @Override
    public List<AuditLog> readByAuditLogUpdatedAt(String auditLogUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuditLogQuery.READ_BY_AUDIT_LOG_AUDITLOGUPDATEDAT, true)
                .addParameter("auditLogUpdatedAt", auditLogUpdatedAt)
                .executeAndFetch(AuditLog.class);
    }

@Override
public AuditLogPage findAuditLog(AuditLogFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(AuditLogQuery.READ);

    // Dynamic filters

    if (filter.getAuditLogId() != null) {   baseSql.append(" AND auditLogId = :auditLogId"); }
    if (filter.getAuditLogUserId() != null) {   baseSql.append(" AND auditLogUserId = :auditLogUserId"); }
    if (filter.getAuditLogAction() != null) {   baseSql.append(" AND auditLogAction = :auditLogAction"); }
    if (filter.getAuditLogRequest() != null) {   baseSql.append(" AND auditLogRequest = :auditLogRequest"); }
    if (filter.getAuditLogResponse() != null) {   baseSql.append(" AND auditLogResponse = :auditLogResponse"); }
    if (filter.getAuditLogModule() != null) {   baseSql.append(" AND auditLogModule = :auditLogModule"); }
    if (filter.getAuditLogResponseCode() != null) {   baseSql.append(" AND auditLogResponseCode = :auditLogResponseCode"); }
    if (filter.getAuditLogResponseMessage() != null) {   baseSql.append(" AND auditLogResponseMessage = :auditLogResponseMessage"); }
    if (filter.getAuditLogStatus() != null) {   baseSql.append(" AND auditLogStatus = :auditLogStatus"); }
    if (filter.getAuditLogCreatedAt() != null) {   baseSql.append(" AND auditLogCreatedAt = :auditLogCreatedAt"); }
    if (filter.getAuditLogUpdatedAt() != null) {   baseSql.append(" AND auditLogUpdatedAt = :auditLogUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getAuditLogId() != null) countQuery.addParameter("auditLogId", filter.getAuditLogId());
     if (filter.getAuditLogUserId() != null) countQuery.addParameter("auditLogUserId", filter.getAuditLogUserId());
     if (filter.getAuditLogAction() != null) countQuery.addParameter("auditLogAction", filter.getAuditLogAction());
     if (filter.getAuditLogRequest() != null) countQuery.addParameter("auditLogRequest", filter.getAuditLogRequest());
     if (filter.getAuditLogResponse() != null) countQuery.addParameter("auditLogResponse", filter.getAuditLogResponse());
     if (filter.getAuditLogModule() != null) countQuery.addParameter("auditLogModule", filter.getAuditLogModule());
     if (filter.getAuditLogResponseCode() != null) countQuery.addParameter("auditLogResponseCode", filter.getAuditLogResponseCode());
     if (filter.getAuditLogResponseMessage() != null) countQuery.addParameter("auditLogResponseMessage", filter.getAuditLogResponseMessage());
     if (filter.getAuditLogStatus() != null) countQuery.addParameter("auditLogStatus", filter.getAuditLogStatus());
     if (filter.getAuditLogCreatedAt() != null) countQuery.addParameter("auditLogCreatedAt", filter.getAuditLogCreatedAt());
     if (filter.getAuditLogUpdatedAt() != null) countQuery.addParameter("auditLogUpdatedAt", filter.getAuditLogUpdatedAt());
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

    if (filter.getAuditLogId() != null) pageQuery.addParameter("auditLogId", filter.getAuditLogId());
    if (filter.getAuditLogUserId() != null) pageQuery.addParameter("auditLogUserId", filter.getAuditLogUserId());
    if (filter.getAuditLogAction() != null) pageQuery.addParameter("auditLogAction", filter.getAuditLogAction());
    if (filter.getAuditLogRequest() != null) pageQuery.addParameter("auditLogRequest", filter.getAuditLogRequest());
    if (filter.getAuditLogResponse() != null) pageQuery.addParameter("auditLogResponse", filter.getAuditLogResponse());
    if (filter.getAuditLogModule() != null) pageQuery.addParameter("auditLogModule", filter.getAuditLogModule());
    if (filter.getAuditLogResponseCode() != null) pageQuery.addParameter("auditLogResponseCode", filter.getAuditLogResponseCode());
    if (filter.getAuditLogResponseMessage() != null) pageQuery.addParameter("auditLogResponseMessage", filter.getAuditLogResponseMessage());
    if (filter.getAuditLogStatus() != null) pageQuery.addParameter("auditLogStatus", filter.getAuditLogStatus());
    if (filter.getAuditLogCreatedAt() != null) pageQuery.addParameter("auditLogCreatedAt", filter.getAuditLogCreatedAt());
    if (filter.getAuditLogUpdatedAt() != null) pageQuery.addParameter("auditLogUpdatedAt", filter.getAuditLogUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<AuditLog> data = pageQuery.executeAndFetch(AuditLog.class);

     return new AuditLogPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "auditLogId","auditLogUserId","auditLogAction","auditLogRequest","auditLogResponse","auditLogModule","auditLogResponseCode","auditLogResponseMessage","auditLogStatus","auditLogCreatedAt","auditLogUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
