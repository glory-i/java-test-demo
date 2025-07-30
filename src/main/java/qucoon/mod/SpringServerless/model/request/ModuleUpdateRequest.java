package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ModuleUpdateRequest {
public int moduleId;
public String moduleName;
public String moduleDescription;
public String moduleStatus;
public String moduleCreatedAt;
public String moduleUpdatedAt;
}
