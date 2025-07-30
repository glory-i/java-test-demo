package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PrivilegeUpdateRequest {
public int privilegeId;
public String privilegeCode;
public String privilegeName;
public String privilegeModuleName;
public String privilegeDescription;
public String privilegeStatus;
public String privilegeCreatedAt;
public String privilegeUpdatedAt;
}
