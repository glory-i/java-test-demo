
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
public class ModuleRepositoryImpl implements ModuleRepository {

    private final Environment environment;

    @Autowired
    public ModuleRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Module  module) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int moduleId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), ModuleQuery.INSERT, true)
                .bind (module)
                .executeUpdate()
                .getKey(int.class);


        return moduleId;
    }

    @Override
    public void bulkCreate(List<Module> modules) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,ModuleQuery.INSERT, false);
            for (Module module : modules) {
                query.bind(module).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Module module) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.UPDATE, true)
                .bind (module)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int moduleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.DELETE, true)
                .addParameter("moduleId", moduleId)
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
                    .execute(ModuleQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Module> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.READ, true)
                .executeAndFetch(Module.class);
    }
    @Override
    public Module readByModuleId(int moduleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.READ_BY_MODULE_MODULEID, true)
                .addParameter("moduleId", moduleId)
                .executeAndFetch (Module.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Module> readByModuleName(String moduleName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.READ_BY_MODULE_MODULENAME, true)
                .addParameter("moduleName", moduleName)
                .executeAndFetch(Module.class);
    }
    @Override
    public List<Module> readByModuleDescription(String moduleDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.READ_BY_MODULE_MODULEDESCRIPTION, true)
                .addParameter("moduleDescription", moduleDescription)
                .executeAndFetch(Module.class);
    }
    @Override
    public List<Module> readByModuleStatus(String moduleStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.READ_BY_MODULE_MODULESTATUS, true)
                .addParameter("moduleStatus", moduleStatus)
                .executeAndFetch(Module.class);
    }
    @Override
    public List<Module> readByModuleCreatedAt(String moduleCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.READ_BY_MODULE_MODULECREATEDAT, true)
                .addParameter("moduleCreatedAt", moduleCreatedAt)
                .executeAndFetch(Module.class);
    }
    @Override
    public List<Module> readByModuleUpdatedAt(String moduleUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ModuleQuery.READ_BY_MODULE_MODULEUPDATEDAT, true)
                .addParameter("moduleUpdatedAt", moduleUpdatedAt)
                .executeAndFetch(Module.class);
    }

@Override
public ModulePage findModule(ModuleFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(ModuleQuery.READ);

    // Dynamic filters

    if (filter.getModuleId() != null) {   baseSql.append(" AND moduleId = :moduleId"); }
    if (filter.getModuleName() != null) {   baseSql.append(" AND moduleName = :moduleName"); }
    if (filter.getModuleDescription() != null) {   baseSql.append(" AND moduleDescription = :moduleDescription"); }
    if (filter.getModuleStatus() != null) {   baseSql.append(" AND moduleStatus = :moduleStatus"); }
    if (filter.getModuleCreatedAt() != null) {   baseSql.append(" AND moduleCreatedAt = :moduleCreatedAt"); }
    if (filter.getModuleUpdatedAt() != null) {   baseSql.append(" AND moduleUpdatedAt = :moduleUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getModuleId() != null) countQuery.addParameter("moduleId", filter.getModuleId());
     if (filter.getModuleName() != null) countQuery.addParameter("moduleName", filter.getModuleName());
     if (filter.getModuleDescription() != null) countQuery.addParameter("moduleDescription", filter.getModuleDescription());
     if (filter.getModuleStatus() != null) countQuery.addParameter("moduleStatus", filter.getModuleStatus());
     if (filter.getModuleCreatedAt() != null) countQuery.addParameter("moduleCreatedAt", filter.getModuleCreatedAt());
     if (filter.getModuleUpdatedAt() != null) countQuery.addParameter("moduleUpdatedAt", filter.getModuleUpdatedAt());
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

    if (filter.getModuleId() != null) pageQuery.addParameter("moduleId", filter.getModuleId());
    if (filter.getModuleName() != null) pageQuery.addParameter("moduleName", filter.getModuleName());
    if (filter.getModuleDescription() != null) pageQuery.addParameter("moduleDescription", filter.getModuleDescription());
    if (filter.getModuleStatus() != null) pageQuery.addParameter("moduleStatus", filter.getModuleStatus());
    if (filter.getModuleCreatedAt() != null) pageQuery.addParameter("moduleCreatedAt", filter.getModuleCreatedAt());
    if (filter.getModuleUpdatedAt() != null) pageQuery.addParameter("moduleUpdatedAt", filter.getModuleUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Module> data = pageQuery.executeAndFetch(Module.class);

     return new ModulePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "moduleId","moduleName","moduleDescription","moduleStatus","moduleCreatedAt","moduleUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
