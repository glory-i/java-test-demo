
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   CourseQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
COURSE   SET   courseStatus   =   'DELETED',   courseUpdatedAt   =   GETDATE() 
WHERE   courseId=:courseId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
COURSE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
COURSE   WHERE   courseStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
COURSE(

 courseUserId,
 courseName,
 courseDescription,
 courseStatus ,
 courseCreatedAt  ,
 courseUpdatedAt ,
courseStatus,
courseCreatedAt,
courseUpdatedAt
)   VALUES   (

 :courseUserId,
 :courseName,
 :courseDescription,
 :courseStatus ,
 :courseCreatedAt  ,
 :courseUpdatedAt ,
 COALESCE(:courseStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
COURSE   SET

 courseUserId = :courseUserId,
 courseName = :courseName,
 courseDescription = :courseDescription,
 courseStatus  = :courseStatus ,
 courseCreatedAt   = :courseCreatedAt  ,
 courseUpdatedAt  = :courseUpdatedAt ,
 courseStatus=:userStatus,
 courseUpdatedAt = GETDATE()
WHERE   courseId=:courseId
""";


public   static   final   String   READ_BY_COURSE_COURSEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
COURSE   WHERE   courseId=:courseId   AND   courseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_COURSE_COURSEUSERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
COURSE   WHERE   courseUserId=:courseUserId   AND   courseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_COURSE_COURSENAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
COURSE   WHERE   courseName=:courseName   AND   courseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_COURSE_COURSEDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
COURSE   WHERE   courseDescription=:courseDescription   AND   courseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_COURSE_COURSESTATUS   =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
COURSE   WHERE   courseStatus =:courseStatus    AND   courseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_COURSE_COURSECREATEDAT    =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
COURSE   WHERE   courseCreatedAt  =:courseCreatedAt     AND   courseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_COURSE_COURSEUPDATEDAT   =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
COURSE   WHERE   courseUpdatedAt =:courseUpdatedAt    AND   courseStatus<>'DELETED'
""";



private   CourseQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
