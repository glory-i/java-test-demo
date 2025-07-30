package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserOtpFilterRequest {

private Integer userOtpId;
private String userOtpUsername;
private String userOtpOtp;
private String userOtpStatus;
private String userOtpCreatedAt;
private String userOtpUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
