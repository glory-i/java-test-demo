package qucoon.mod.SpringServerless.utility.exception;



        import com.google.gson.Gson;
        import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
        import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;

        import java.security.InvalidKeyException;
        import java.util.function.Supplier;

/**
 * Utility class for handling exceptions and returning appropriate JSON responses.
 */
public class ExceptionHandlerUtil {

    private static final Gson GSON = new Gson();

    public static String exceptionWrapper(Supplier<Object> action) {
        try {
            return action.get().toString();
        } catch (Exception ex) {
            BaseResponse response = getErrorResponse(ex);
            ex.printStackTrace();
            return GSON.toJson(response);
        }
    }

    private static BaseResponse getErrorResponse(Exception ex) {
        if (ex instanceof CustomExceptions.OtpExpiredException) {
            return copyResponse(ResponseConstant.INSTANCE.getERROR_TOKEN_EXPIRED(), ex);
        } else if (ex instanceof CustomExceptions.UnableToLocateRecordException) {
            return copyResponse(ResponseConstant.INSTANCE.getUNABLE_TO_LOCATE_RECORD(), ex);
        } else if (ex instanceof CustomExceptions.InvalidOtpException) {
            return copyResponse(ResponseConstant.INSTANCE.getINVALID_TOKEN(), ex);
        } else if (ex instanceof CustomExceptions.BadRequestException) {
            return copyResponse(ResponseConstant.INSTANCE.getBAD_REQUEST(), ex);
        } else if (ex instanceof CustomExceptions.RecordAlreadyExistException) {
            return copyResponse(ResponseConstant.INSTANCE.getRECORD_ALREADY_EXISTS(), ex);
        } else if (ex instanceof CustomExceptions.BadConnectionException) {
            return copyResponse(ResponseConstant.INSTANCE.getRECORD_ALREADY_EXISTS(), ex);
        } else if (ex instanceof CustomExceptions.FailedToCreateRecordException) {
            return copyResponse(ResponseConstant.INSTANCE.getFAILED_TO_CREATE_RECORD(), ex);
        } else if (ex instanceof CustomExceptions.FailedToUpdateRecordException) {
            return copyResponse(ResponseConstant.INSTANCE.getFAILED_TO_UPDATE_RECORD(), ex);
        } else if (ex instanceof CustomExceptions.SuspectedMalfunctionException) {
            return copyResponse(ResponseConstant.INSTANCE.getSUSPECTED_MALFUNCTION(), ex);
        } else if (ex instanceof CustomExceptions.AccountDeletedException) {
            return copyResponse(ResponseConstant.INSTANCE.getACCOUNT_DELETED(), ex);
        } else if (ex instanceof InvalidKeyException) {
            return copyResponse(ResponseConstant.INSTANCE.getERROR_AUTHENTICATION_FAILED(), ex);
        } else if (ex instanceof CustomExceptions.UnauthorizedAccessException) {
            return copyResponse(ResponseConstant.INSTANCE.getACCESS_DENIED(), ex);
        } else if (ex instanceof CustomExceptions.InvalidPathException) {
            return copyResponse(ResponseConstant.INSTANCE.getFORMAT_ERROR(), ex);
        } else if (ex instanceof CustomExceptions.IncorrectPasswordException) {
            return copyResponse(ResponseConstant.INSTANCE.getERROR_AUTHENTICATION_FAILED(), ex);
        } else if (ex instanceof CustomExceptions.AccessNotAllowedException) {
            return copyResponse(ResponseConstant.INSTANCE.getACCESS_DENIED(), ex);
        } else if (ex instanceof CustomExceptions.InvalidTransactionException) {
            return copyResponse(ResponseConstant.INSTANCE.getINVALID_TRANSACTION(), ex);
        } else if (ex instanceof CustomExceptions.NotSufficientFundsException) {
            return copyResponse(ResponseConstant.INSTANCE.getNOT_SUFFICIENT_FUNDS(), ex);
        } else if (ex instanceof CustomExceptions.DuplicateTransactionException) {
            return copyResponse(ResponseConstant.INSTANCE.getDUPLICATE_RECORD(), ex);
        } else if (ex instanceof CustomExceptions.HonourWithIdentificationException) {
            return copyResponse(ResponseConstant.INSTANCE.getHONOUR_WITH_IDENTIFICATION(), ex);
        } else if (ex instanceof CustomExceptions.ActivityAlreadyPerformedException) {
            return copyResponse(ResponseConstant.INSTANCE.getERROR_ACTIVITY_ALREADY_PERFORMED(), ex);
        } else {
            return copyResponse(ResponseConstant.INSTANCE.getSUSPECTED_MALFUNCTION(), ex);
        }
    }

    private static BaseResponse copyResponse(BaseResponse response, Exception ex) {
        return new BaseResponse(response.getResponseCode(), ex.getMessage() != null ? ex.getMessage() : response.getResponseMessage());
    }
}
