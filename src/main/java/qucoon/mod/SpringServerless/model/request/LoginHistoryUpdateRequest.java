package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LoginHistoryUpdateRequest {
public int loginHistoryId;
public String loginHistoryUsername;
public String loginHistoryIpAddress;
public String loginHistoryDeviceId;
public String loginHistoryLongitude;
public String loginHistoryLatitude;
public String loginHistoryStatus;
public String loginHistoryCreatedAt;
public String loginHistoryUpdatedAt;
}
