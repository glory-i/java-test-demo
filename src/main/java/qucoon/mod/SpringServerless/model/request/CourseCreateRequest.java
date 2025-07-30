package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class CourseCreateRequest {
@NotNull(message = "courseUserId is required")
public int courseUserId;
public String courseName;
public String courseDescription;
public String courseStatus ;
public String courseCreatedAt  ;
public String courseUpdatedAt ;
}
