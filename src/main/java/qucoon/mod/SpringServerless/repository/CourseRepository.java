
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.CoursePage;
import qucoon.mod.SpringServerless.model.request.CourseFilterRequest;

import java.util.List;

@Repository
    public interface CourseRepository {


    // Additional query methods can be defined here.
    int create(Course course);
    void bulkCreate(List<Course>  course);
    int update(Course  course);
    int delete(int courseId);
    CoursePage findCourse(CourseFilterRequest filter);
    boolean truncate();
    List<Course> read();
    Course readByCourseId(int courseId);
    List<Course> readByCourseUserId(int courseUserId);
    List<Course> readByCourseName(String courseName);
    List<Course> readByCourseDescription(String courseDescription);
    List<Course> readByCourseStatus (String courseStatus );
    List<Course> readByCourseCreatedAt  (String courseCreatedAt  );
    List<Course> readByCourseUpdatedAt (String courseUpdatedAt );
}
