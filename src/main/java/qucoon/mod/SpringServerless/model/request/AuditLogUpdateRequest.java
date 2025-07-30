package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AuditLogUpdateRequest {
public int auditLogId;
public int auditLogUserId;
public String auditLogAction;
public String auditLogRequest;
public String auditLogResponse;
public String auditLogModule;
public String auditLogResponseCode;
public String auditLogResponseMessage;
public String auditLogStatus;
public String auditLogCreatedAt;
public String auditLogUpdatedAt;
}
