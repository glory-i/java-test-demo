package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LoginHistory;


@Data
public class LoginHistoryDto  {

private Integer loginHistoryId;
private String loginHistoryUsername;
private String loginHistoryIpAddress;
private String loginHistoryDeviceId;
private String loginHistoryLongitude;
private String loginHistoryLatitude;
private String loginHistoryStatus;
private String loginHistoryCreatedAt;
private String loginHistoryUpdatedAt;

public static LoginHistoryDto from(LoginHistory p) {
    LoginHistoryDto dto = new LoginHistoryDto();

    dto.setLoginHistoryId(p.getLoginHistoryId());
    dto.setLoginHistoryUsername(p.getLoginHistoryUsername());
    dto.setLoginHistoryIpAddress(p.getLoginHistoryIpAddress());
    dto.setLoginHistoryDeviceId(p.getLoginHistoryDeviceId());
    dto.setLoginHistoryLongitude(p.getLoginHistoryLongitude());
    dto.setLoginHistoryLatitude(p.getLoginHistoryLatitude());
    dto.setLoginHistoryStatus(p.getLoginHistoryStatus());
    dto.setLoginHistoryCreatedAt(p.getLoginHistoryCreatedAt());
    dto.setLoginHistoryUpdatedAt(p.getLoginHistoryUpdatedAt());
    return dto;
   }
}
