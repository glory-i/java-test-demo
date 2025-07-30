
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AuditLogPage;
import qucoon.mod.SpringServerless.model.request.AuditLogFilterRequest;

import java.util.List;

@Repository
    public interface AuditLogRepository {


    // Additional query methods can be defined here.
    int create(AuditLog auditlog);
    void bulkCreate(List<AuditLog>  auditlog);
    int update(AuditLog  auditlog);
    int delete(int auditLogId);
    AuditLogPage findAuditLog(AuditLogFilterRequest filter);
    boolean truncate();
    List<AuditLog> read();
    AuditLog readByAuditLogId(int auditLogId);
    List<AuditLog> readByAuditLogUserId(int auditLogUserId);
    List<AuditLog> readByAuditLogAction(String auditLogAction);
    List<AuditLog> readByAuditLogRequest(String auditLogRequest);
    List<AuditLog> readByAuditLogResponse(String auditLogResponse);
    List<AuditLog> readByAuditLogModule(String auditLogModule);
    List<AuditLog> readByAuditLogResponseCode(String auditLogResponseCode);
    List<AuditLog> readByAuditLogResponseMessage(String auditLogResponseMessage);
    List<AuditLog> readByAuditLogStatus(String auditLogStatus);
    List<AuditLog> readByAuditLogCreatedAt(String auditLogCreatedAt);
    List<AuditLog> readByAuditLogUpdatedAt(String auditLogUpdatedAt);
}
