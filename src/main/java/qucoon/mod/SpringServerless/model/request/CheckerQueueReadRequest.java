package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CheckerQueueReadRequest {
@NotEmpty(message = "Checkerqueueid is required")
public int checkerQueueId;
@NotEmpty(message = "Checkerqueuemakerid is required")
public int checkerQueueMakerId;
@NotEmpty(message = "Checkerqueuecheckerid is required")
public int checkerQueueCheckerId;
@NotEmpty(message = "Checkerqueuemodule is required")
public String checkerQueueModule;
@NotEmpty(message = "Checkerqueueaction is required")
public String checkerQueueAction;
@NotEmpty(message = "Checkerqueuerequest is required")
public String checkerQueueRequest;
@NotEmpty(message = "Checkerqueuereason is required")
public String checkerQueueReason;
@NotEmpty(message = "Checkerqueuestatus is required")
public String checkerQueueStatus;
@NotEmpty(message = "Checkerqueuecreatedat is required")
public String checkerQueueCreatedAt;
@NotEmpty(message = "Checkerqueueupdatedat is required")
public String checkerQueueUpdatedAt;
}
