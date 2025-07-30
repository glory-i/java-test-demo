
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Module;
import java.util.List;

@Data
@AllArgsConstructor
public class ModulePage {
    private List<Module> data;
    private long totalRecords;
}
