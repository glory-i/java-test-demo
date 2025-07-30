package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LoginHistoryFilterRequest {

private Integer loginHistoryId;
private String loginHistoryUsername;
private String loginHistoryIpAddress;
private String loginHistoryDeviceId;
private String loginHistoryLongitude;
private String loginHistoryLatitude;
private String loginHistoryStatus;
private String loginHistoryCreatedAt;
private String loginHistoryUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
