
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   RolePrivilegeQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   SET   roleprivilegeStatus   =   'DELETED',   roleprivilegeUpdatedAt   =   GETDATE() 
WHERE   rolePrivilegeId=:rolePrivilegeId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   WHERE   roleprivilegeStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE(

 rolePrivilegeRoleId,
 rolePrivilegePrivilegeCode,
rolePrivilegeStatus,
rolePrivilegeCreatedAt,
rolePrivilegeUpdatedAt
)   VALUES   (

 :rolePrivilegeRoleId,
 :rolePrivilegePrivilegeCode,
 COALESCE(:rolePrivilegeStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   SET

 rolePrivilegeRoleId = :rolePrivilegeRoleId,
 rolePrivilegePrivilegeCode = :rolePrivilegePrivilegeCode,
 rolePrivilegeStatus=:userStatus,
 rolePrivilegeUpdatedAt = GETDATE()
WHERE   rolePrivilegeId=:rolePrivilegeId
""";


public   static   final   String   READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   WHERE   rolePrivilegeId=:rolePrivilegeId   AND   roleprivilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGEROLEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   WHERE   rolePrivilegeRoleId=:rolePrivilegeRoleId   AND   roleprivilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGEPRIVILEGECODE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   WHERE   rolePrivilegePrivilegeCode=:rolePrivilegePrivilegeCode   AND   roleprivilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   WHERE   rolePrivilegeStatus=:rolePrivilegeStatus   AND   roleprivilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   WHERE   rolePrivilegeCreatedAt=:rolePrivilegeCreatedAt   AND   roleprivilegeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_PRIVILEGE_ROLEPRIVILEGEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE_PRIVILEGE   WHERE   rolePrivilegeUpdatedAt=:rolePrivilegeUpdatedAt   AND   roleprivilegeStatus<>'DELETED'
""";



private   RolePrivilegeQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
