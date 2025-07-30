package qucoon.mod.SpringServerless.model.entity;


import lombok.Data;
import qucoon.mod.SpringServerless.repository.annotation.Column;
import qucoon.mod.SpringServerless.repository.annotation.Table;
import qucoon.mod.SpringServerless.utility.constant.PrefixConstant;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;


@Data
@Table
public class AuditLog  {
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  auditLogId;
@Column(type="int",nullable=true )
public int  auditLogUserId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  auditLogAction;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  auditLogRequest;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  auditLogResponse;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  auditLogModule;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  auditLogResponseCode;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  auditLogResponseMessage;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  auditLogStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  auditLogCreatedAt;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  auditLogUpdatedAt;
}
