
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
import qucoon.mod.SpringServerless.repository.page.UserOtpPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.UserOtpDto;


@Service
public class UserOtpService {

    private final UserOtpRepository userotpRepository;
    private  final Gson GSON;


    public UserOtpService(UserOtpRepository userotpRepository) {
        this.userotpRepository = userotpRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(UserOtpCreateRequest request) {

        UserOtp userotp = GSON.fromJson(GSON.toJson(request), UserOtp.class);
        if (userotp.getUserOtpStatus() == null) {
            userotp.setUserOtpStatus("ACTIVE");
        }
        userotpRepository.create(userotp);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<UserOtpCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            UserOtp[] userotpArray = GSON.fromJson(json, UserOtp[].class);
            List<UserOtp> userotps = Arrays.asList(userotpArray);
            userotpRepository.bulkCreate(userotps);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(UserOtpUpdateRequest request) {
        UserOtp userotp = userotpRepository.readByUserOtpId(request.getUserOtpId());
        if (userotp == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        userotpRepository.update(userotp);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int userOtpId) {
        int updateResponse = userotpRepository.delete(userOtpId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public UserOtpReadListResponse read() {
        List<UserOtp> userotps = userotpRepository.read();
       if(userotps == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new UserOtpReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), userotps);
    }
   public UserOtpReadPagedResponse search(UserOtpFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       UserOtpPage page = userotpRepository.findUserOtp(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<UserOtpDto> dtos = page.getData().stream()
            .map(UserOtpDto::from)
            .collect(Collectors.toList());
    return new UserOtpReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public UserOtpReadSingleResponse readByUserOtpId(int userotpid) {
        UserOtp userotp = userotpRepository.readByUserOtpId(userotpid);
        if (userotp == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new UserOtpReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                userotp);
    }
    public UserOtpReadListResponse readByUserOtpUsername(String userotpusername) {
        List<UserOtp> userotps = userotpRepository.readByUserOtpUsername(userotpusername);
        return new UserOtpReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        userotps);
    }
    public UserOtpReadListResponse readByUserOtpOtp(String userotpotp) {
        List<UserOtp> userotps = userotpRepository.readByUserOtpOtp(userotpotp);
        return new UserOtpReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        userotps);
    }
    public UserOtpReadListResponse readByUserOtpStatus(String userotpstatus) {
        List<UserOtp> userotps = userotpRepository.readByUserOtpStatus(userotpstatus);
        return new UserOtpReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        userotps);
    }
    public UserOtpReadListResponse readByUserOtpCreatedAt(String userotpcreatedat) {
        List<UserOtp> userotps = userotpRepository.readByUserOtpCreatedAt(userotpcreatedat);
        return new UserOtpReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        userotps);
    }
    public UserOtpReadListResponse readByUserOtpUpdatedAt(String userotpupdatedat) {
        List<UserOtp> userotps = userotpRepository.readByUserOtpUpdatedAt(userotpupdatedat);
        return new UserOtpReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        userotps);
    }
}
