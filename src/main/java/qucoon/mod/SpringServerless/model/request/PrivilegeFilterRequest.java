package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PrivilegeFilterRequest {

private Integer privilegeId;
private String privilegeCode;
private String privilegeName;
private String privilegeModuleName;
private String privilegeDescription;
private String privilegeStatus;
private String privilegeCreatedAt;
private String privilegeUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
