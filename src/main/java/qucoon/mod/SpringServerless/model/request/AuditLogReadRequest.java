package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AuditLogReadRequest {
@NotEmpty(message = "Auditlogid is required")
public int auditLogId;
@NotEmpty(message = "Auditloguserid is required")
public int auditLogUserId;
@NotEmpty(message = "Auditlogaction is required")
public String auditLogAction;
@NotEmpty(message = "Auditlogrequest is required")
public String auditLogRequest;
@NotEmpty(message = "Auditlogresponse is required")
public String auditLogResponse;
@NotEmpty(message = "Auditlogmodule is required")
public String auditLogModule;
@NotEmpty(message = "Auditlogresponsecode is required")
public String auditLogResponseCode;
@NotEmpty(message = "Auditlogresponsemessage is required")
public String auditLogResponseMessage;
@NotEmpty(message = "Auditlogstatus is required")
public String auditLogStatus;
@NotEmpty(message = "Auditlogcreatedat is required")
public String auditLogCreatedAt;
@NotEmpty(message = "Auditlogupdatedat is required")
public String auditLogUpdatedAt;
}
