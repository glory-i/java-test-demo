package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LoginHistoryReadRequest {
@NotEmpty(message = "Loginhistoryid is required")
public int loginHistoryId;
@NotEmpty(message = "Loginhistoryusername is required")
public String loginHistoryUsername;
@NotEmpty(message = "Loginhistoryipaddress is required")
public String loginHistoryIpAddress;
@NotEmpty(message = "Loginhistorydeviceid is required")
public String loginHistoryDeviceId;
@NotEmpty(message = "Loginhistorylongitude is required")
public String loginHistoryLongitude;
@NotEmpty(message = "Loginhistorylatitude is required")
public String loginHistoryLatitude;
@NotEmpty(message = "Loginhistorystatus is required")
public String loginHistoryStatus;
@NotEmpty(message = "Loginhistorycreatedat is required")
public String loginHistoryCreatedAt;
@NotEmpty(message = "Loginhistoryupdatedat is required")
public String loginHistoryUpdatedAt;
}
