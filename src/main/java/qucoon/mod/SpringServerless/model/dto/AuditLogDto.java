package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AuditLog;


@Data
public class AuditLogDto  {

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

public static AuditLogDto from(AuditLog p) {
    AuditLogDto dto = new AuditLogDto();

    dto.setAuditLogId(p.getAuditLogId());
    dto.setAuditLogUserId(p.getAuditLogUserId());
    dto.setAuditLogAction(p.getAuditLogAction());
    dto.setAuditLogRequest(p.getAuditLogRequest());
    dto.setAuditLogResponse(p.getAuditLogResponse());
    dto.setAuditLogModule(p.getAuditLogModule());
    dto.setAuditLogResponseCode(p.getAuditLogResponseCode());
    dto.setAuditLogResponseMessage(p.getAuditLogResponseMessage());
    dto.setAuditLogStatus(p.getAuditLogStatus());
    dto.setAuditLogCreatedAt(p.getAuditLogCreatedAt());
    dto.setAuditLogUpdatedAt(p.getAuditLogUpdatedAt());
    return dto;
   }
}
