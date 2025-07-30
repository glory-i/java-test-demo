package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CheckerQueueFilterRequest {

private Integer checkerQueueId;
private Integer checkerQueueMakerId;
private Integer checkerQueueCheckerId;
private String checkerQueueModule;
private String checkerQueueAction;
private String checkerQueueRequest;
private String checkerQueueReason;
private String checkerQueueStatus;
private String checkerQueueCreatedAt;
private String checkerQueueUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
