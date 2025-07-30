
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Role;
import java.util.List;

@Data
@AllArgsConstructor
public class RolePage {
    private List<Role> data;
    private long totalRecords;
}
