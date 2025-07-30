package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CheckerQueueUpdateRequest {
public int checkerQueueId;
public int checkerQueueMakerId;
public int checkerQueueCheckerId;
public String checkerQueueModule;
public String checkerQueueAction;
public String checkerQueueRequest;
public String checkerQueueReason;
public String checkerQueueStatus;
public String checkerQueueCreatedAt;
public String checkerQueueUpdatedAt;
}
