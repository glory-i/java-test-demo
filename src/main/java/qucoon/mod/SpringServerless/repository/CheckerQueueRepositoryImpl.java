
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
public class CheckerQueueRepositoryImpl implements CheckerQueueRepository {

    private final Environment environment;

    @Autowired
    public CheckerQueueRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(CheckerQueue  checkerqueue) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int checkerQueueId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), CheckerQueueQuery.INSERT, true)
                .bind (checkerqueue)
                .executeUpdate()
                .getKey(int.class);


        return checkerQueueId;
    }

    @Override
    public void bulkCreate(List<CheckerQueue> checkerqueues) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,CheckerQueueQuery.INSERT, false);
            for (CheckerQueue checkerqueue : checkerqueues) {
                query.bind(checkerqueue).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(CheckerQueue checkerqueue) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.UPDATE, true)
                .bind (checkerqueue)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int checkerQueueId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.DELETE, true)
                .addParameter("checkerQueueId", checkerQueueId)
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
                    .execute(CheckerQueueQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CheckerQueue> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ, true)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public CheckerQueue readByCheckerQueueId(int checkerQueueId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUEID, true)
                .addParameter("checkerQueueId", checkerQueueId)
                .executeAndFetch (CheckerQueue.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueMakerId(int checkerQueueMakerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUEMAKERID, true)
                .addParameter("checkerQueueMakerId", checkerQueueMakerId)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueCheckerId(int checkerQueueCheckerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUECHECKERID, true)
                .addParameter("checkerQueueCheckerId", checkerQueueCheckerId)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueModule(String checkerQueueModule) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUEMODULE, true)
                .addParameter("checkerQueueModule", checkerQueueModule)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueAction(String checkerQueueAction) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUEACTION, true)
                .addParameter("checkerQueueAction", checkerQueueAction)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueRequest(String checkerQueueRequest) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUEREQUEST, true)
                .addParameter("checkerQueueRequest", checkerQueueRequest)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueReason(String checkerQueueReason) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUEREASON, true)
                .addParameter("checkerQueueReason", checkerQueueReason)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueStatus(String checkerQueueStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUESTATUS, true)
                .addParameter("checkerQueueStatus", checkerQueueStatus)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueCreatedAt(String checkerQueueCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUECREATEDAT, true)
                .addParameter("checkerQueueCreatedAt", checkerQueueCreatedAt)
                .executeAndFetch(CheckerQueue.class);
    }
    @Override
    public List<CheckerQueue> readByCheckerQueueUpdatedAt(String checkerQueueUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CheckerQueueQuery.READ_BY_CHECKER_QUEUE_CHECKERQUEUEUPDATEDAT, true)
                .addParameter("checkerQueueUpdatedAt", checkerQueueUpdatedAt)
                .executeAndFetch(CheckerQueue.class);
    }

@Override
public CheckerQueuePage findCheckerQueue(CheckerQueueFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(CheckerQueueQuery.READ);

    // Dynamic filters

    if (filter.getCheckerQueueId() != null) {   baseSql.append(" AND checkerQueueId = :checkerQueueId"); }
    if (filter.getCheckerQueueMakerId() != null) {   baseSql.append(" AND checkerQueueMakerId = :checkerQueueMakerId"); }
    if (filter.getCheckerQueueCheckerId() != null) {   baseSql.append(" AND checkerQueueCheckerId = :checkerQueueCheckerId"); }
    if (filter.getCheckerQueueModule() != null) {   baseSql.append(" AND checkerQueueModule = :checkerQueueModule"); }
    if (filter.getCheckerQueueAction() != null) {   baseSql.append(" AND checkerQueueAction = :checkerQueueAction"); }
    if (filter.getCheckerQueueRequest() != null) {   baseSql.append(" AND checkerQueueRequest = :checkerQueueRequest"); }
    if (filter.getCheckerQueueReason() != null) {   baseSql.append(" AND checkerQueueReason = :checkerQueueReason"); }
    if (filter.getCheckerQueueStatus() != null) {   baseSql.append(" AND checkerQueueStatus = :checkerQueueStatus"); }
    if (filter.getCheckerQueueCreatedAt() != null) {   baseSql.append(" AND checkerQueueCreatedAt = :checkerQueueCreatedAt"); }
    if (filter.getCheckerQueueUpdatedAt() != null) {   baseSql.append(" AND checkerQueueUpdatedAt = :checkerQueueUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getCheckerQueueId() != null) countQuery.addParameter("checkerQueueId", filter.getCheckerQueueId());
     if (filter.getCheckerQueueMakerId() != null) countQuery.addParameter("checkerQueueMakerId", filter.getCheckerQueueMakerId());
     if (filter.getCheckerQueueCheckerId() != null) countQuery.addParameter("checkerQueueCheckerId", filter.getCheckerQueueCheckerId());
     if (filter.getCheckerQueueModule() != null) countQuery.addParameter("checkerQueueModule", filter.getCheckerQueueModule());
     if (filter.getCheckerQueueAction() != null) countQuery.addParameter("checkerQueueAction", filter.getCheckerQueueAction());
     if (filter.getCheckerQueueRequest() != null) countQuery.addParameter("checkerQueueRequest", filter.getCheckerQueueRequest());
     if (filter.getCheckerQueueReason() != null) countQuery.addParameter("checkerQueueReason", filter.getCheckerQueueReason());
     if (filter.getCheckerQueueStatus() != null) countQuery.addParameter("checkerQueueStatus", filter.getCheckerQueueStatus());
     if (filter.getCheckerQueueCreatedAt() != null) countQuery.addParameter("checkerQueueCreatedAt", filter.getCheckerQueueCreatedAt());
     if (filter.getCheckerQueueUpdatedAt() != null) countQuery.addParameter("checkerQueueUpdatedAt", filter.getCheckerQueueUpdatedAt());
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

    if (filter.getCheckerQueueId() != null) pageQuery.addParameter("checkerQueueId", filter.getCheckerQueueId());
    if (filter.getCheckerQueueMakerId() != null) pageQuery.addParameter("checkerQueueMakerId", filter.getCheckerQueueMakerId());
    if (filter.getCheckerQueueCheckerId() != null) pageQuery.addParameter("checkerQueueCheckerId", filter.getCheckerQueueCheckerId());
    if (filter.getCheckerQueueModule() != null) pageQuery.addParameter("checkerQueueModule", filter.getCheckerQueueModule());
    if (filter.getCheckerQueueAction() != null) pageQuery.addParameter("checkerQueueAction", filter.getCheckerQueueAction());
    if (filter.getCheckerQueueRequest() != null) pageQuery.addParameter("checkerQueueRequest", filter.getCheckerQueueRequest());
    if (filter.getCheckerQueueReason() != null) pageQuery.addParameter("checkerQueueReason", filter.getCheckerQueueReason());
    if (filter.getCheckerQueueStatus() != null) pageQuery.addParameter("checkerQueueStatus", filter.getCheckerQueueStatus());
    if (filter.getCheckerQueueCreatedAt() != null) pageQuery.addParameter("checkerQueueCreatedAt", filter.getCheckerQueueCreatedAt());
    if (filter.getCheckerQueueUpdatedAt() != null) pageQuery.addParameter("checkerQueueUpdatedAt", filter.getCheckerQueueUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<CheckerQueue> data = pageQuery.executeAndFetch(CheckerQueue.class);

     return new CheckerQueuePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "checkerQueueId","checkerQueueMakerId","checkerQueueCheckerId","checkerQueueModule","checkerQueueAction","checkerQueueRequest","checkerQueueReason","checkerQueueStatus","checkerQueueCreatedAt","checkerQueueUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
