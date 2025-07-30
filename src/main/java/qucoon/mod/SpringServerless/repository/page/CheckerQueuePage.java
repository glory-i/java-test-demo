
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.CheckerQueue;
import java.util.List;

@Data
@AllArgsConstructor
public class CheckerQueuePage {
    private List<CheckerQueue> data;
    private long totalRecords;
}
