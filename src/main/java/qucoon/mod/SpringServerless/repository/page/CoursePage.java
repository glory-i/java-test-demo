
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Course;
import java.util.List;

@Data
@AllArgsConstructor
public class CoursePage {
    private List<Course> data;
    private long totalRecords;
}
