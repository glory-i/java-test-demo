
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LoginHistory;
import java.util.List;

@Data
@AllArgsConstructor
public class LoginHistoryPage {
    private List<LoginHistory> data;
    private long totalRecords;
}
