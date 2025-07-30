package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class LoginHistoryCreateRequest {
public String loginHistoryUsername;
public String loginHistoryIpAddress;
public String loginHistoryDeviceId;
public String loginHistoryLongitude;
public String loginHistoryLatitude;
}
