
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.UserOtpPage;
import qucoon.mod.SpringServerless.model.request.UserOtpFilterRequest;

import java.util.List;

@Repository
    public interface UserOtpRepository {


    // Additional query methods can be defined here.
    int create(UserOtp userotp);
    void bulkCreate(List<UserOtp>  userotp);
    int update(UserOtp  userotp);
    int delete(int userOtpId);
    UserOtpPage findUserOtp(UserOtpFilterRequest filter);
    boolean truncate();
    List<UserOtp> read();
    UserOtp readByUserOtpId(int userOtpId);
    List<UserOtp> readByUserOtpUsername(String userOtpUsername);
    List<UserOtp> readByUserOtpOtp(String userOtpOtp);
    List<UserOtp> readByUserOtpStatus(String userOtpStatus);
    List<UserOtp> readByUserOtpCreatedAt(String userOtpCreatedAt);
    List<UserOtp> readByUserOtpUpdatedAt(String userOtpUpdatedAt);
}
