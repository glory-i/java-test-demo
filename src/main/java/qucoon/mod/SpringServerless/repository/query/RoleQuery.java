
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   RoleQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ROLE   SET   roleStatus   =   'DELETED',   roleUpdatedAt   =   GETDATE() 
WHERE   rolePrivilegeId=:rolePrivilegeId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ROLE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ROLE   WHERE   roleStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ROLE(

 roleName,
 roleDescription,
 roleIsPublic,
 rolePrivilegeRoleId,
 rolePrivilegePrivilegeCode,
 rolePrivilegeStatus,
 rolePrivilegeCreatedAt,
 rolePrivilegeUpdatedAt,
roleStatus,
roleCreatedAt,
roleUpdatedAt
)   VALUES   (

 :roleName,
 :roleDescription,
 :roleIsPublic,
 :rolePrivilegeRoleId,
 :rolePrivilegePrivilegeCode,
 :rolePrivilegeStatus,
 :rolePrivilegeCreatedAt,
 :rolePrivilegeUpdatedAt,
 COALESCE(:roleStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ROLE   SET

 roleName = :roleName,
 roleDescription = :roleDescription,
 roleIsPublic = :roleIsPublic,
 rolePrivilegeRoleId = :rolePrivilegeRoleId,
 rolePrivilegePrivilegeCode = :rolePrivilegePrivilegeCode,
 rolePrivilegeStatus = :rolePrivilegeStatus,
 rolePrivilegeCreatedAt = :rolePrivilegeCreatedAt,
 rolePrivilegeUpdatedAt = :rolePrivilegeUpdatedAt,
 roleStatus=:userStatus,
 roleUpdatedAt = GETDATE()
WHERE   rolePrivilegeId=:rolePrivilegeId
""";


public   static   final   String   READ_BY_ROLE_ROLEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   roleId=:roleId   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLENAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   roleName=:roleName   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   roleDescription=:roleDescription   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEISPUBLIC  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   roleIsPublic=:roleIsPublic   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   roleStatus=:roleStatus   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   roleCreatedAt=:roleCreatedAt   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   roleUpdatedAt=:roleUpdatedAt   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEPRIVILEGEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   rolePrivilegeId=:rolePrivilegeId   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEPRIVILEGEROLEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   rolePrivilegeRoleId=:rolePrivilegeRoleId   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEPRIVILEGEPRIVILEGECODE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   rolePrivilegePrivilegeCode=:rolePrivilegePrivilegeCode   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEPRIVILEGESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   rolePrivilegeStatus=:rolePrivilegeStatus   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEPRIVILEGECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   rolePrivilegeCreatedAt=:rolePrivilegeCreatedAt   AND   roleStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ROLE_ROLEPRIVILEGEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ROLE   WHERE   rolePrivilegeUpdatedAt=:rolePrivilegeUpdatedAt   AND   roleStatus<>'DELETED'
""";



private   RoleQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
