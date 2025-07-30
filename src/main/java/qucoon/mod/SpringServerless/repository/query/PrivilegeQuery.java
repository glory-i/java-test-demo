
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   PrivilegeQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
PRIVILEGE   SET   privilegeStatus   =   'DELETED',   privilegeUpdatedAt   =   GETDATE() 
WHERE   privilegeId=:privilegeId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
PRIVILEGE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
PRIVILEGE(

 privilegeCode,
 privilegeName,
 privilegeModuleName,
 privilegeDescription,
privilegeStatus,
privilegeCreatedAt,
privilegeUpdatedAt
)   VALUES   (

 :privilegeCode,
 :privilegeName,
 :privilegeModuleName,
 :privilegeDescription,
 COALESCE(:privilegeStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
PRIVILEGE   SET

 privilegeCode = :privilegeCode,
 privilegeName = :privilegeName,
 privilegeModuleName = :privilegeModuleName,
 privilegeDescription = :privilegeDescription,
 privilegeStatus=:userStatus,
 privilegeUpdatedAt = GETDATE()
WHERE   privilegeId=:privilegeId
""";


public   static   final   String   READ_BY_PRIVILEGE_PRIVILEGEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeId=:privilegeId   AND   privilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRIVILEGE_PRIVILEGECODE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeCode=:privilegeCode   AND   privilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRIVILEGE_PRIVILEGENAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeName=:privilegeName   AND   privilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRIVILEGE_PRIVILEGEMODULENAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeModuleName=:privilegeModuleName   AND   privilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRIVILEGE_PRIVILEGEDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeDescription=:privilegeDescription   AND   privilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRIVILEGE_PRIVILEGESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeStatus=:privilegeStatus   AND   privilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRIVILEGE_PRIVILEGECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeCreatedAt=:privilegeCreatedAt   AND   privilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PRIVILEGE_PRIVILEGEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PRIVILEGE   WHERE   privilegeUpdatedAt=:privilegeUpdatedAt   AND   privilegeStatus<>'DELETED'
""";



private   PrivilegeQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
