package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CourseUpdateRequest {
public int courseId;
public int courseUserId;
public String courseName;
public String courseDescription;
public String courseStatus ;
public String courseCreatedAt  ;
public String courseUpdatedAt ;
}
