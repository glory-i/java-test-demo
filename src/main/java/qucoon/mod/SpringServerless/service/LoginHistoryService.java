
package   qucoon.mod.SpringServerless.service;


import qucoon.mod.SpringServerless.utility.exception.CustomExceptions;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;
import qucoon.mod.SpringServerless.model.entity.User;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.*;
import qucoon.mod.SpringServerless.utility.LocalDateTimeTypeAdapter;
import qucoon.mod.SpringServerless.repository.*;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.LoginHistoryPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.LoginHistoryDto;


@Service
public class LoginHistoryService {

    private final LoginHistoryRepository loginhistoryRepository;
    private  final Gson GSON;


    public LoginHistoryService(LoginHistoryRepository loginhistoryRepository) {
        this.loginhistoryRepository = loginhistoryRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(LoginHistoryCreateRequest request) {

        LoginHistory loginhistory = GSON.fromJson(GSON.toJson(request), LoginHistory.class);
        if (loginhistory.getLoginHistoryStatus() == null) {
            loginhistory.setLoginHistoryStatus("ACTIVE");
        }
        loginhistoryRepository.create(loginhistory);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<LoginHistoryCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            LoginHistory[] loginhistoryArray = GSON.fromJson(json, LoginHistory[].class);
            List<LoginHistory> loginhistorys = Arrays.asList(loginhistoryArray);
            loginhistoryRepository.bulkCreate(loginhistorys);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(LoginHistoryUpdateRequest request) {
        LoginHistory loginhistory = loginhistoryRepository.readByLoginHistoryId(request.getLoginHistoryId());
        if (loginhistory == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        loginhistoryRepository.update(loginhistory);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int loginHistoryId) {
        int updateResponse = loginhistoryRepository.delete(loginHistoryId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public LoginHistoryReadListResponse read() {
        List<LoginHistory> loginhistorys = loginhistoryRepository.read();
       if(loginhistorys == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LoginHistoryReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), loginhistorys);
    }
   public LoginHistoryReadPagedResponse search(LoginHistoryFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       LoginHistoryPage page = loginhistoryRepository.findLoginHistory(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<LoginHistoryDto> dtos = page.getData().stream()
            .map(LoginHistoryDto::from)
            .collect(Collectors.toList());
    return new LoginHistoryReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public LoginHistoryReadSingleResponse readByLoginHistoryId(int loginhistoryid) {
        LoginHistory loginhistory = loginhistoryRepository.readByLoginHistoryId(loginhistoryid);
        if (loginhistory == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LoginHistoryReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                loginhistory);
    }
    public LoginHistoryReadListResponse readByLoginHistoryUsername(String loginhistoryusername) {
        List<LoginHistory> loginhistorys = loginhistoryRepository.readByLoginHistoryUsername(loginhistoryusername);
        return new LoginHistoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        loginhistorys);
    }
    public LoginHistoryReadListResponse readByLoginHistoryIpAddress(String loginhistoryipaddress) {
        List<LoginHistory> loginhistorys = loginhistoryRepository.readByLoginHistoryIpAddress(loginhistoryipaddress);
        return new LoginHistoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        loginhistorys);
    }
    public LoginHistoryReadListResponse readByLoginHistoryDeviceId(String loginhistorydeviceid) {
        List<LoginHistory> loginhistorys = loginhistoryRepository.readByLoginHistoryDeviceId(loginhistorydeviceid);
        return new LoginHistoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        loginhistorys);
    }
    public LoginHistoryReadListResponse readByLoginHistoryLongitude(String loginhistorylongitude) {
        List<LoginHistory> loginhistorys = loginhistoryRepository.readByLoginHistoryLongitude(loginhistorylongitude);
        return new LoginHistoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        loginhistorys);
    }
    public LoginHistoryReadListResponse readByLoginHistoryLatitude(String loginhistorylatitude) {
        List<LoginHistory> loginhistorys = loginhistoryRepository.readByLoginHistoryLatitude(loginhistorylatitude);
        return new LoginHistoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        loginhistorys);
    }
    public LoginHistoryReadListResponse readByLoginHistoryStatus(String loginhistorystatus) {
        List<LoginHistory> loginhistorys = loginhistoryRepository.readByLoginHistoryStatus(loginhistorystatus);
        return new LoginHistoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        loginhistorys);
    }
    public LoginHistoryReadListResponse readByLoginHistoryCreatedAt(String loginhistorycreatedat) {
        List<LoginHistory> loginhistorys = loginhistoryRepository.readByLoginHistoryCreatedAt(loginhistorycreatedat);
        return new LoginHistoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        loginhistorys);
    }
    public LoginHistoryReadListResponse readByLoginHistoryUpdatedAt(String loginhistoryupdatedat) {
        List<LoginHistory> loginhistorys = loginhistoryRepository.readByLoginHistoryUpdatedAt(loginhistoryupdatedat);
        return new LoginHistoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        loginhistorys);
    }
}
