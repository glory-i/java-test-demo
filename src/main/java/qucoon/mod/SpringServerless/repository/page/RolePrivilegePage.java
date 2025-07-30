
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.RolePrivilege;
import java.util.List;

@Data
@AllArgsConstructor
public class RolePrivilegePage {
    private List<RolePrivilege> data;
    private long totalRecords;
}
