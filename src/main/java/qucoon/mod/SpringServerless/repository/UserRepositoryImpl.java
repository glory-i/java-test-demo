
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
public class UserRepositoryImpl implements UserRepository {

    private final Environment environment;

    @Autowired
    public UserRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(User  user) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int userId  = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), UserQuery.INSERT, true)
                .bind (user)
                .executeUpdate()
                .getKey(int.class);


        return userId ;
    }

    @Override
    public void bulkCreate(List<User> users) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,UserQuery.INSERT, false);
            for (User user : users) {
                query.bind(user).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(User user) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.UPDATE, true)
                .bind (user)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int userId ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.DELETE, true)
                .addParameter("userId ", userId )
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
                    .execute(UserQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ, true)
                .executeAndFetch(User.class);
    }
    @Override
    public User readByUserId (int userId ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERID , true)
                .addParameter("userId ", userId )
                .executeAndFetch (User.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<User> readByUserRoleId (int userRoleId ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERROLEID , true)
                .addParameter("userRoleId ", userRoleId )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserEmail (String userEmail ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USEREMAIL , true)
                .addParameter("userEmail ", userEmail )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserFirstName (String userFirstName ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERFIRSTNAME , true)
                .addParameter("userFirstName ", userFirstName )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserLastName (String userLastName ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERLASTNAME , true)
                .addParameter("userLastName ", userLastName )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserPassword (String userPassword ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERPASSWORD , true)
                .addParameter("userPassword ", userPassword )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserPhoneNumber (String userPhoneNumber ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERPHONENUMBER , true)
                .addParameter("userPhoneNumber ", userPhoneNumber )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserJobRoleAlias (String userJobRoleAlias ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERJOBROLEALIAS , true)
                .addParameter("userJobRoleAlias ", userJobRoleAlias )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserStatus (String userStatus ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERSTATUS , true)
                .addParameter("userStatus ", userStatus )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserCreatedAt  (String userCreatedAt  ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERCREATEDAT  , true)
                .addParameter("userCreatedAt  ", userCreatedAt  )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserUpdatedAt (String userUpdatedAt ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERUPDATEDAT , true)
                .addParameter("userUpdatedAt ", userUpdatedAt )
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserLoginCount(int userLoginCount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERLOGINCOUNT, true)
                .addParameter("userLoginCount", userLoginCount)
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserLastLoginDate(String userLastLoginDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERLASTLOGINDATE, true)
                .addParameter("userLastLoginDate", userLastLoginDate)
                .executeAndFetch(User.class);
    }
    @Override
    public List<User> readByUserLastLoginIpAddress(String userLastLoginIpAddress) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),UserQuery.READ_BY_USER_USERLASTLOGINIPADDRESS, true)
                .addParameter("userLastLoginIpAddress", userLastLoginIpAddress)
                .executeAndFetch(User.class);
    }

@Override
public UserPage findUser(UserFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(UserQuery.READ);

    // Dynamic filters

    if (filter.getUserId () != null) {   baseSql.append(" AND userId  = :userId "); }
    if (filter.getUserRoleId () != null) {   baseSql.append(" AND userRoleId  = :userRoleId "); }
    if (filter.getUserEmail () != null) {   baseSql.append(" AND userEmail  = :userEmail "); }
    if (filter.getUserFirstName () != null) {   baseSql.append(" AND userFirstName  = :userFirstName "); }
    if (filter.getUserLastName () != null) {   baseSql.append(" AND userLastName  = :userLastName "); }
    if (filter.getUserPassword () != null) {   baseSql.append(" AND userPassword  = :userPassword "); }
    if (filter.getUserPhoneNumber () != null) {   baseSql.append(" AND userPhoneNumber  = :userPhoneNumber "); }
    if (filter.getUserJobRoleAlias () != null) {   baseSql.append(" AND userJobRoleAlias  = :userJobRoleAlias "); }
    if (filter.getUserStatus () != null) {   baseSql.append(" AND userStatus  = :userStatus "); }
    if (filter.getUserCreatedAt  () != null) {   baseSql.append(" AND userCreatedAt   = :userCreatedAt  "); }
    if (filter.getUserUpdatedAt () != null) {   baseSql.append(" AND userUpdatedAt  = :userUpdatedAt "); }
    if (filter.getUserLoginCount() != null) {   baseSql.append(" AND userLoginCount = :userLoginCount"); }
    if (filter.getUserLastLoginDate() != null) {   baseSql.append(" AND userLastLoginDate = :userLastLoginDate"); }
    if (filter.getUserLastLoginIpAddress() != null) {   baseSql.append(" AND userLastLoginIpAddress = :userLastLoginIpAddress"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getUserId () != null) countQuery.addParameter("userId ", filter.getUserId ());
     if (filter.getUserRoleId () != null) countQuery.addParameter("userRoleId ", filter.getUserRoleId ());
     if (filter.getUserEmail () != null) countQuery.addParameter("userEmail ", filter.getUserEmail ());
     if (filter.getUserFirstName () != null) countQuery.addParameter("userFirstName ", filter.getUserFirstName ());
     if (filter.getUserLastName () != null) countQuery.addParameter("userLastName ", filter.getUserLastName ());
     if (filter.getUserPassword () != null) countQuery.addParameter("userPassword ", filter.getUserPassword ());
     if (filter.getUserPhoneNumber () != null) countQuery.addParameter("userPhoneNumber ", filter.getUserPhoneNumber ());
     if (filter.getUserJobRoleAlias () != null) countQuery.addParameter("userJobRoleAlias ", filter.getUserJobRoleAlias ());
     if (filter.getUserStatus () != null) countQuery.addParameter("userStatus ", filter.getUserStatus ());
     if (filter.getUserCreatedAt  () != null) countQuery.addParameter("userCreatedAt  ", filter.getUserCreatedAt  ());
     if (filter.getUserUpdatedAt () != null) countQuery.addParameter("userUpdatedAt ", filter.getUserUpdatedAt ());
     if (filter.getUserLoginCount() != null) countQuery.addParameter("userLoginCount", filter.getUserLoginCount());
     if (filter.getUserLastLoginDate() != null) countQuery.addParameter("userLastLoginDate", filter.getUserLastLoginDate());
     if (filter.getUserLastLoginIpAddress() != null) countQuery.addParameter("userLastLoginIpAddress", filter.getUserLastLoginIpAddress());
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

    if (filter.getUserId () != null) pageQuery.addParameter("userId ", filter.getUserId ());
    if (filter.getUserRoleId () != null) pageQuery.addParameter("userRoleId ", filter.getUserRoleId ());
    if (filter.getUserEmail () != null) pageQuery.addParameter("userEmail ", filter.getUserEmail ());
    if (filter.getUserFirstName () != null) pageQuery.addParameter("userFirstName ", filter.getUserFirstName ());
    if (filter.getUserLastName () != null) pageQuery.addParameter("userLastName ", filter.getUserLastName ());
    if (filter.getUserPassword () != null) pageQuery.addParameter("userPassword ", filter.getUserPassword ());
    if (filter.getUserPhoneNumber () != null) pageQuery.addParameter("userPhoneNumber ", filter.getUserPhoneNumber ());
    if (filter.getUserJobRoleAlias () != null) pageQuery.addParameter("userJobRoleAlias ", filter.getUserJobRoleAlias ());
    if (filter.getUserStatus () != null) pageQuery.addParameter("userStatus ", filter.getUserStatus ());
    if (filter.getUserCreatedAt  () != null) pageQuery.addParameter("userCreatedAt  ", filter.getUserCreatedAt  ());
    if (filter.getUserUpdatedAt () != null) pageQuery.addParameter("userUpdatedAt ", filter.getUserUpdatedAt ());
    if (filter.getUserLoginCount() != null) pageQuery.addParameter("userLoginCount", filter.getUserLoginCount());
    if (filter.getUserLastLoginDate() != null) pageQuery.addParameter("userLastLoginDate", filter.getUserLastLoginDate());
    if (filter.getUserLastLoginIpAddress() != null) pageQuery.addParameter("userLastLoginIpAddress", filter.getUserLastLoginIpAddress());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<User> data = pageQuery.executeAndFetch(User.class);

     return new UserPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "userId ","userRoleId ","userEmail ","userFirstName ","userLastName ","userPassword ","userPhoneNumber ","userJobRoleAlias ","userStatus ","userCreatedAt  ","userUpdatedAt ","userLoginCount","userLastLoginDate","userLastLoginIpAddress"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
