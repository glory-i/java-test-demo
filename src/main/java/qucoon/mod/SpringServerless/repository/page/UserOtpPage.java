
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.UserOtp;
import java.util.List;

@Data
@AllArgsConstructor
public class UserOtpPage {
    private List<UserOtp> data;
    private long totalRecords;
}
