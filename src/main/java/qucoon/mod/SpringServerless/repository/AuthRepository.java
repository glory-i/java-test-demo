
package qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.User;

@Repository
    public interface AuthRepository {
    int updateLogin(User  user);

}
