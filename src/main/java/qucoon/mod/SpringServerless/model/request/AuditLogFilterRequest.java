package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditLogFilterRequest {

private Integer auditLogId;
private Integer auditLogUserId;
private String auditLogAction;
private String auditLogRequest;
private String auditLogResponse;
private String auditLogModule;
private String auditLogResponseCode;
private String auditLogResponseMessage;
private String auditLogStatus;
private String auditLogCreatedAt;
private String auditLogUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
