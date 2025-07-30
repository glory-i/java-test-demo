package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CourseFilterRequest {

private Integer courseId;
private Integer courseUserId;
private String courseName;
private String courseDescription;
private String courseStatus ;
private String courseCreatedAt  ;
private String courseUpdatedAt ;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
