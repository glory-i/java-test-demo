package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ModuleFilterRequest {

private Integer moduleId;
private String moduleName;
private String moduleDescription;
private String moduleStatus;
private String moduleCreatedAt;
private String moduleUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
