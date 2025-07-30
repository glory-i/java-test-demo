package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserOtpReadRequest {
@NotEmpty(message = "Userotpid is required")
public int userOtpId;
@NotEmpty(message = "Userotpusername is required")
public String userOtpUsername;
@NotEmpty(message = "Userotpotp is required")
public String userOtpOtp;
@NotEmpty(message = "Userotpstatus is required")
public String userOtpStatus;
@NotEmpty(message = "Userotpcreatedat is required")
public String userOtpCreatedAt;
@NotEmpty(message = "Userotpupdatedat is required")
public String userOtpUpdatedAt;
}
