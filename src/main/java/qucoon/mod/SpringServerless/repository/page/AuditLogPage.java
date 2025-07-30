
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AuditLog;
import java.util.List;

@Data
@AllArgsConstructor
public class AuditLogPage {
    private List<AuditLog> data;
    private long totalRecords;
}
