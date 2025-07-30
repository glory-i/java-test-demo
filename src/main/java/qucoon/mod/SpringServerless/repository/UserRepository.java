
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.UserPage;
import qucoon.mod.SpringServerless.model.request.UserFilterRequest;

import java.util.List;

@Repository
    public interface UserRepository {


    // Additional query methods can be defined here.
    int create(User user);
    void bulkCreate(List<User>  user);
    int update(User  user);
    int delete(int userId );
    UserPage findUser(UserFilterRequest filter);
    boolean truncate();
    List<User> read();
    User readByUserId (int userId );
    List<User> readByUserRoleId (int userRoleId );
    List<User> readByUserEmail (String userEmail );
    List<User> readByUserFirstName (String userFirstName );
    List<User> readByUserLastName (String userLastName );
    List<User> readByUserPassword (String userPassword );
    List<User> readByUserPhoneNumber (String userPhoneNumber );
    List<User> readByUserJobRoleAlias (String userJobRoleAlias );
    List<User> readByUserStatus (String userStatus );
    List<User> readByUserCreatedAt  (String userCreatedAt  );
    List<User> readByUserUpdatedAt (String userUpdatedAt );
    List<User> readByUserLoginCount(int userLoginCount);
    List<User> readByUserLastLoginDate(String userLastLoginDate);
    List<User> readByUserLastLoginIpAddress(String userLastLoginIpAddress);
}
