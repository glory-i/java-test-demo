package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.CheckerQueue;


@Data
public class CheckerQueueDto  {

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

public static CheckerQueueDto from(CheckerQueue p) {
    CheckerQueueDto dto = new CheckerQueueDto();

    dto.setCheckerQueueId(p.getCheckerQueueId());
    dto.setCheckerQueueMakerId(p.getCheckerQueueMakerId());
    dto.setCheckerQueueCheckerId(p.getCheckerQueueCheckerId());
    dto.setCheckerQueueModule(p.getCheckerQueueModule());
    dto.setCheckerQueueAction(p.getCheckerQueueAction());
    dto.setCheckerQueueRequest(p.getCheckerQueueRequest());
    dto.setCheckerQueueReason(p.getCheckerQueueReason());
    dto.setCheckerQueueStatus(p.getCheckerQueueStatus());
    dto.setCheckerQueueCreatedAt(p.getCheckerQueueCreatedAt());
    dto.setCheckerQueueUpdatedAt(p.getCheckerQueueUpdatedAt());
    return dto;
   }
}
