

package qucoon.mod.SpringServerless.repository.query;

import qucoon.mod.SpringServerless.utility.constant.PrefixConstant;

public   class AuthQuery {


    public   static   final   String   UPDATE_LOGIN   =   """
Update """ + PrefixConstant.ENTITY + """
User   SET
 userLoginCount = :userLoginCount,
 userLastLoginDate = :userLastLoginDate,
 userLastLoginIpAddress = :userLastLoginIpAddress
WHERE   userId=:userId
""";

    
private AuthQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
