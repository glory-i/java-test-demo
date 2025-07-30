package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.UserOtp;


@Data
public class UserOtpDto  {

private Integer userOtpId;
private String userOtpUsername;
private String userOtpOtp;
private String userOtpStatus;
private String userOtpCreatedAt;
private String userOtpUpdatedAt;

public static UserOtpDto from(UserOtp p) {
    UserOtpDto dto = new UserOtpDto();

    dto.setUserOtpId(p.getUserOtpId());
    dto.setUserOtpUsername(p.getUserOtpUsername());
    dto.setUserOtpOtp(p.getUserOtpOtp());
    dto.setUserOtpStatus(p.getUserOtpStatus());
    dto.setUserOtpCreatedAt(p.getUserOtpCreatedAt());
    dto.setUserOtpUpdatedAt(p.getUserOtpUpdatedAt());
    return dto;
   }
}
