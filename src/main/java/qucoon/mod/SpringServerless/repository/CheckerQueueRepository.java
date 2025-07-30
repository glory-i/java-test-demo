
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.CheckerQueuePage;
import qucoon.mod.SpringServerless.model.request.CheckerQueueFilterRequest;

import java.util.List;

@Repository
    public interface CheckerQueueRepository {


    // Additional query methods can be defined here.
    int create(CheckerQueue checkerqueue);
    void bulkCreate(List<CheckerQueue>  checkerqueue);
    int update(CheckerQueue  checkerqueue);
    int delete(int checkerQueueId);
    CheckerQueuePage findCheckerQueue(CheckerQueueFilterRequest filter);
    boolean truncate();
    List<CheckerQueue> read();
    CheckerQueue readByCheckerQueueId(int checkerQueueId);
    List<CheckerQueue> readByCheckerQueueMakerId(int checkerQueueMakerId);
    List<CheckerQueue> readByCheckerQueueCheckerId(int checkerQueueCheckerId);
    List<CheckerQueue> readByCheckerQueueModule(String checkerQueueModule);
    List<CheckerQueue> readByCheckerQueueAction(String checkerQueueAction);
    List<CheckerQueue> readByCheckerQueueRequest(String checkerQueueRequest);
    List<CheckerQueue> readByCheckerQueueReason(String checkerQueueReason);
    List<CheckerQueue> readByCheckerQueueStatus(String checkerQueueStatus);
    List<CheckerQueue> readByCheckerQueueCreatedAt(String checkerQueueCreatedAt);
    List<CheckerQueue> readByCheckerQueueUpdatedAt(String checkerQueueUpdatedAt);
}
