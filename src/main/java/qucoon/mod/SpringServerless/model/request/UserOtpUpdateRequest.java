package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserOtpUpdateRequest {
public int userOtpId;
public String userOtpUsername;
public String userOtpOtp;
public String userOtpStatus;
public String userOtpCreatedAt;
public String userOtpUpdatedAt;
}
