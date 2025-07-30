package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class CheckerQueueCreateRequest {
@NotNull(message = "checkerQueueMakerId is required")
public int checkerQueueMakerId;
@NotNull(message = "checkerQueueCheckerId is required")
public int checkerQueueCheckerId;
@NotEmpty(message = "checkerQueueModule is required")
public String checkerQueueModule;
public String checkerQueueAction;
public String checkerQueueRequest;
public String checkerQueueReason;
}
