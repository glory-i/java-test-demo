
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
public class CourseRepositoryImpl implements CourseRepository {

    private final Environment environment;

    @Autowired
    public CourseRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Course  course) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int courseId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), CourseQuery.INSERT, true)
                .bind (course)
                .executeUpdate()
                .getKey(int.class);


        return courseId;
    }

    @Override
    public void bulkCreate(List<Course> courses) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,CourseQuery.INSERT, false);
            for (Course course : courses) {
                query.bind(course).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Course course) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.UPDATE, true)
                .bind (course)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int courseId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.DELETE, true)
                .addParameter("courseId", courseId)
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
                    .execute(CourseQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Course> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.READ, true)
                .executeAndFetch(Course.class);
    }
    @Override
    public Course readByCourseId(int courseId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.READ_BY_COURSE_COURSEID, true)
                .addParameter("courseId", courseId)
                .executeAndFetch (Course.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Course> readByCourseUserId(int courseUserId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.READ_BY_COURSE_COURSEUSERID, true)
                .addParameter("courseUserId", courseUserId)
                .executeAndFetch(Course.class);
    }
    @Override
    public List<Course> readByCourseName(String courseName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.READ_BY_COURSE_COURSENAME, true)
                .addParameter("courseName", courseName)
                .executeAndFetch(Course.class);
    }
    @Override
    public List<Course> readByCourseDescription(String courseDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.READ_BY_COURSE_COURSEDESCRIPTION, true)
                .addParameter("courseDescription", courseDescription)
                .executeAndFetch(Course.class);
    }
    @Override
    public List<Course> readByCourseStatus (String courseStatus ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.READ_BY_COURSE_COURSESTATUS , true)
                .addParameter("courseStatus ", courseStatus )
                .executeAndFetch(Course.class);
    }
    @Override
    public List<Course> readByCourseCreatedAt  (String courseCreatedAt  ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.READ_BY_COURSE_COURSECREATEDAT  , true)
                .addParameter("courseCreatedAt  ", courseCreatedAt  )
                .executeAndFetch(Course.class);
    }
    @Override
    public List<Course> readByCourseUpdatedAt (String courseUpdatedAt ) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),CourseQuery.READ_BY_COURSE_COURSEUPDATEDAT , true)
                .addParameter("courseUpdatedAt ", courseUpdatedAt )
                .executeAndFetch(Course.class);
    }

@Override
public CoursePage findCourse(CourseFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(CourseQuery.READ);

    // Dynamic filters

    if (filter.getCourseId() != null) {   baseSql.append(" AND courseId = :courseId"); }
    if (filter.getCourseUserId() != null) {   baseSql.append(" AND courseUserId = :courseUserId"); }
    if (filter.getCourseName() != null) {   baseSql.append(" AND courseName = :courseName"); }
    if (filter.getCourseDescription() != null) {   baseSql.append(" AND courseDescription = :courseDescription"); }
    if (filter.getCourseStatus () != null) {   baseSql.append(" AND courseStatus  = :courseStatus "); }
    if (filter.getCourseCreatedAt  () != null) {   baseSql.append(" AND courseCreatedAt   = :courseCreatedAt  "); }
    if (filter.getCourseUpdatedAt () != null) {   baseSql.append(" AND courseUpdatedAt  = :courseUpdatedAt "); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getCourseId() != null) countQuery.addParameter("courseId", filter.getCourseId());
     if (filter.getCourseUserId() != null) countQuery.addParameter("courseUserId", filter.getCourseUserId());
     if (filter.getCourseName() != null) countQuery.addParameter("courseName", filter.getCourseName());
     if (filter.getCourseDescription() != null) countQuery.addParameter("courseDescription", filter.getCourseDescription());
     if (filter.getCourseStatus () != null) countQuery.addParameter("courseStatus ", filter.getCourseStatus ());
     if (filter.getCourseCreatedAt  () != null) countQuery.addParameter("courseCreatedAt  ", filter.getCourseCreatedAt  ());
     if (filter.getCourseUpdatedAt () != null) countQuery.addParameter("courseUpdatedAt ", filter.getCourseUpdatedAt ());
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

    if (filter.getCourseId() != null) pageQuery.addParameter("courseId", filter.getCourseId());
    if (filter.getCourseUserId() != null) pageQuery.addParameter("courseUserId", filter.getCourseUserId());
    if (filter.getCourseName() != null) pageQuery.addParameter("courseName", filter.getCourseName());
    if (filter.getCourseDescription() != null) pageQuery.addParameter("courseDescription", filter.getCourseDescription());
    if (filter.getCourseStatus () != null) pageQuery.addParameter("courseStatus ", filter.getCourseStatus ());
    if (filter.getCourseCreatedAt  () != null) pageQuery.addParameter("courseCreatedAt  ", filter.getCourseCreatedAt  ());
    if (filter.getCourseUpdatedAt () != null) pageQuery.addParameter("courseUpdatedAt ", filter.getCourseUpdatedAt ());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Course> data = pageQuery.executeAndFetch(Course.class);

     return new CoursePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "courseId","courseUserId","courseName","courseDescription","courseStatus ","courseCreatedAt  ","courseUpdatedAt "
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
