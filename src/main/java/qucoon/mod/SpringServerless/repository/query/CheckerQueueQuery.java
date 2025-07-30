
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   CheckerQueueQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   SET   checkerqueueStatus   =   'DELETED',   checkerqueueUpdatedAt   =   GETDATE() 
WHERE   checkerQueueId=:checkerQueueId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerqueueStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE(

 checkerQueueMakerId,
 checkerQueueCheckerId,
 checkerQueueModule,
 checkerQueueAction,
 checkerQueueRequest,
 checkerQueueReason,
checkerQueueStatus,
checkerQueueCreatedAt,
checkerQueueUpdatedAt
)   VALUES   (

 :checkerQueueMakerId,
 :checkerQueueCheckerId,
 :checkerQueueModule,
 :checkerQueueAction,
 :checkerQueueRequest,
 :checkerQueueReason,
 COALESCE(:checkerQueueStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   SET

 checkerQueueMakerId = :checkerQueueMakerId,
 checkerQueueCheckerId = :checkerQueueCheckerId,
 checkerQueueModule = :checkerQueueModule,
 checkerQueueAction = :checkerQueueAction,
 checkerQueueRequest = :checkerQueueRequest,
 checkerQueueReason = :checkerQueueReason,
 checkerQueueStatus=:userStatus,
 checkerQueueUpdatedAt = GETDATE()
WHERE   checkerQueueId=:checkerQueueId
""";


public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueId=:checkerQueueId   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUEMAKERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueMakerId=:checkerQueueMakerId   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUECHECKERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueCheckerId=:checkerQueueCheckerId   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUEMODULE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueModule=:checkerQueueModule   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUEACTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueAction=:checkerQueueAction   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUEREQUEST  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueRequest=:checkerQueueRequest   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUEREASON  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueReason=:checkerQueueReason   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueStatus=:checkerQueueStatus   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueCreatedAt=:checkerQueueCreatedAt   AND   checkerqueueStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CHECKER_QUEUE_CHECKERQUEUEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CHECKER_QUEUE   WHERE   checkerQueueUpdatedAt=:checkerQueueUpdatedAt   AND   checkerqueueStatus<>'DELETED'
""";



private   CheckerQueueQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
