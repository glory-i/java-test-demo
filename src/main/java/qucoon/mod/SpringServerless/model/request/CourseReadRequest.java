package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CourseReadRequest {
@NotEmpty(message = "Courseid is required")
public int courseId;
@NotEmpty(message = "Courseuserid is required")
public int courseUserId;
@NotEmpty(message = "Coursename is required")
public String courseName;
@NotEmpty(message = "Coursedescription is required")
public String courseDescription;
@NotEmpty(message = "Coursestatus  is required")
public String courseStatus ;
@NotEmpty(message = "Coursecreatedat   is required")
public String courseCreatedAt  ;
@NotEmpty(message = "Courseupdatedat  is required")
public String courseUpdatedAt ;
}
