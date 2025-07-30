package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PrivilegeReadRequest {
@NotEmpty(message = "Privilegeid is required")
public int privilegeId;
@NotEmpty(message = "Privilegecode is required")
public String privilegeCode;
@NotEmpty(message = "Privilegename is required")
public String privilegeName;
@NotEmpty(message = "Privilegemodulename is required")
public String privilegeModuleName;
@NotEmpty(message = "Privilegedescription is required")
public String privilegeDescription;
@NotEmpty(message = "Privilegestatus is required")
public String privilegeStatus;
@NotEmpty(message = "Privilegecreatedat is required")
public String privilegeCreatedAt;
@NotEmpty(message = "Privilegeupdatedat is required")
public String privilegeUpdatedAt;
}
