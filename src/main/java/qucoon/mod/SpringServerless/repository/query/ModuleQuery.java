
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   ModuleQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
MODULE   SET   moduleStatus   =   'DELETED',   moduleUpdatedAt   =   GETDATE() 
WHERE   moduleId=:moduleId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
MODULE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
MODULE   WHERE   moduleStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
MODULE(

 moduleName,
 moduleDescription,
moduleStatus,
moduleCreatedAt,
moduleUpdatedAt
)   VALUES   (

 :moduleName,
 :moduleDescription,
 COALESCE(:moduleStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
MODULE   SET

 moduleName = :moduleName,
 moduleDescription = :moduleDescription,
 moduleStatus=:userStatus,
 moduleUpdatedAt = GETDATE()
WHERE   moduleId=:moduleId
""";


public   static   final   String   READ_BY_MODULE_MODULEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
MODULE   WHERE   moduleId=:moduleId   AND   moduleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_MODULE_MODULENAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
MODULE   WHERE   moduleName=:moduleName   AND   moduleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_MODULE_MODULEDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
MODULE   WHERE   moduleDescription=:moduleDescription   AND   moduleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_MODULE_MODULESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
MODULE   WHERE   moduleStatus=:moduleStatus   AND   moduleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_MODULE_MODULECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
MODULE   WHERE   moduleCreatedAt=:moduleCreatedAt   AND   moduleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_MODULE_MODULEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
MODULE   WHERE   moduleUpdatedAt=:moduleUpdatedAt   AND   moduleStatus<>'DELETED'
""";



private   ModuleQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
