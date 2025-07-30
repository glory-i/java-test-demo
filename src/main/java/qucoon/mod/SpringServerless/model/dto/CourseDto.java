package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Course;


@Data
public class CourseDto  {

private Integer courseId;
private Integer courseUserId;
private String courseName;
private String courseDescription;
private String courseStatus ;
private String courseCreatedAt  ;
private String courseUpdatedAt ;

public static CourseDto from(Course p) {
    CourseDto dto = new CourseDto();

    dto.setCourseId(p.getCourseId());
    dto.setCourseUserId(p.getCourseUserId());
    dto.setCourseName(p.getCourseName());
    dto.setCourseDescription(p.getCourseDescription());
    dto.setCourseStatus (p.getCourseStatus ());
    dto.setCourseCreatedAt  (p.getCourseCreatedAt  ());
    dto.setCourseUpdatedAt (p.getCourseUpdatedAt ());
    return dto;
   }
}
