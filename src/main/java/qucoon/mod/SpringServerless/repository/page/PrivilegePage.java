
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Privilege;
import java.util.List;

@Data
@AllArgsConstructor
public class PrivilegePage {
    private List<Privilege> data;
    private long totalRecords;
}
