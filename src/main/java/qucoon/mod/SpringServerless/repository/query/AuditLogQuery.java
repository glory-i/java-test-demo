
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AuditLogQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
AUDIT_LOG   SET   auditlogStatus   =   'DELETED',   auditlogUpdatedAt   =   GETDATE() 
WHERE   auditLogId=:auditLogId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
AUDIT_LOG
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditlogStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
AUDIT_LOG(

 auditLogUserId,
 auditLogAction,
 auditLogRequest,
 auditLogResponse,
 auditLogModule,
 auditLogResponseCode,
 auditLogResponseMessage,
auditLogStatus,
auditLogCreatedAt,
auditLogUpdatedAt
)   VALUES   (

 :auditLogUserId,
 :auditLogAction,
 :auditLogRequest,
 :auditLogResponse,
 :auditLogModule,
 :auditLogResponseCode,
 :auditLogResponseMessage,
 COALESCE(:auditLogStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
AUDIT_LOG   SET

 auditLogUserId = :auditLogUserId,
 auditLogAction = :auditLogAction,
 auditLogRequest = :auditLogRequest,
 auditLogResponse = :auditLogResponse,
 auditLogModule = :auditLogModule,
 auditLogResponseCode = :auditLogResponseCode,
 auditLogResponseMessage = :auditLogResponseMessage,
 auditLogStatus=:userStatus,
 auditLogUpdatedAt = GETDATE()
WHERE   auditLogId=:auditLogId
""";


public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogId=:auditLogId   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGUSERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogUserId=:auditLogUserId   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGACTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogAction=:auditLogAction   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGREQUEST  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogRequest=:auditLogRequest   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGRESPONSE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogResponse=:auditLogResponse   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGMODULE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogModule=:auditLogModule   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGRESPONSECODE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogResponseCode=:auditLogResponseCode   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGRESPONSEMESSAGE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogResponseMessage=:auditLogResponseMessage   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogStatus=:auditLogStatus   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogCreatedAt=:auditLogCreatedAt   AND   auditlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_AUDIT_LOG_AUDITLOGUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
AUDIT_LOG   WHERE   auditLogUpdatedAt=:auditLogUpdatedAt   AND   auditlogStatus<>'DELETED'
""";



private   AuditLogQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
