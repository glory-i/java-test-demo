

package qucoon.mod.SpringServerless.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.User;
import qucoon.mod.SpringServerless.repository.query.AuthQuery;
import qucoon.mod.SpringServerless.utility.Environment;
import static qucoon.mod.SpringServerless.repository.query.QueryUtils.createQueryWithoutOnMappingFailure;

@Repository
public class AuthRepositoryImpl implements AuthRepository {
    private final Environment environment;

    @Autowired
    public AuthRepositoryImpl(Environment environment) {
       this.environment = environment;
    }

    @Override
    public int updateLogin(User  user) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AuthQuery.UPDATE_LOGIN, true)
                .bind (user)
                .executeUpdate()
                .getResult();
    }



}
