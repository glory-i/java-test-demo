package qucoon.mod.SpringServerless.utility.constant;


import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;

/**
 * Singleton class for managing response messages.
 */
public final class ResponseConstant {

    public static final ResponseConstant INSTANCE = new ResponseConstant();

    private final BaseResponse SUCCESS = new BaseResponse("00", "Completed successfully");
    private final BaseResponse REFER_TO_CARD_ISSUER = new BaseResponse("01", "Refer to card issuer");
    private final BaseResponse UNABLE_TO_LOCATE_RECORD = new BaseResponse("87", "Unable to locate record");
    private final BaseResponse REFER_TO_CARD_ISSUERS_SPECIAL_CONDITIONS = new BaseResponse("02", "Refer to card issuer's special conditions");
    private final BaseResponse INVALID_MERCHANT = new BaseResponse("03", "Invalid merchant");
    private final BaseResponse PICK_UP = new BaseResponse("04", "Pick-up");
    private final BaseResponse DO_NOT_HONOR = new BaseResponse("05", "Do not honor");
    private final BaseResponse PICK_UP_CARD_SPECIAL_CONDITION = new BaseResponse("07", "Pick-up card, special condition");
    private final BaseResponse HONOUR_WITH_IDENTIFICATION = new BaseResponse("08", "Honour with identification");
    private final BaseResponse REQUEST_IN_PROGRESS = new BaseResponse("09", "Request in progress");
    private final BaseResponse APPROVED_FOR_PARTIAL_AMOUNT = new BaseResponse("10", "Approved for partial amount");
    private final BaseResponse APPROVED_VIP = new BaseResponse("11", "Approved (VIP)");
    private final BaseResponse INVALID_TRANSACTION = new BaseResponse("12", "Invalid transaction");
    private final BaseResponse INVALID_AMOUNT = new BaseResponse("13", "Invalid amount");
    private final BaseResponse INVALID_CARD_NUMBER_NO_SUCH_NUMBER = new BaseResponse("14", "Invalid card number (no such number)");
    private final BaseResponse NO_SUCH_ISSUER = new BaseResponse("15", "No such issuer");
    private final BaseResponse APPROVED_UPDATE_TRACK_3 = new BaseResponse("16", "Approved, update track 3");
    private final BaseResponse CUSTOMER_CANCELLATION = new BaseResponse("17", "Customer cancellation");
    private final BaseResponse CUSTOMER_DISPUTE = new BaseResponse("18", "Customer dispute");
    private final BaseResponse RE_ENTER_TRANSACTION = new BaseResponse("19", "Re-enter transaction");
    private final BaseResponse INVALID_RESPONSE = new BaseResponse("20", "Invalid response");
    private final BaseResponse NO_ACTION_TAKEN = new BaseResponse("21", "No action taken");
    private final BaseResponse SUSPECTED_MALFUNCTION = new BaseResponse("22", "Something Went Wrong");
    private final BaseResponse UNACCEPTABLE_TRANSACTION_FEE = new BaseResponse("23", "Unacceptable transaction fee");
    private final BaseResponse FORMAT_ERROR = new BaseResponse("30", "Format error");
    private final BaseResponse COMPLETED_PARTIALLY = new BaseResponse("32", "Completed partially");
    private final BaseResponse EXPIRED_CARD = new BaseResponse("33", "Expired card");
    private final BaseResponse SUSPECTED_FRAUD = new BaseResponse("34", "Suspected fraud");
    private final BaseResponse RESTRICTED_CARD = new BaseResponse("36", "Restricted card");
    private final BaseResponse LOST_CARD = new BaseResponse("41", "Lost card");
    private final BaseResponse NOT_SUFFICIENT_FUNDS = new BaseResponse("51", "Not sufficient funds");
    private final BaseResponse EXCEEDS_WITHDRAWAL_AMOUNT_LIMIT = new BaseResponse("61", "Exceeds withdrawal amount limit");
    private final BaseResponse SECURITY_VIOLATION = new BaseResponse("63", "Security violation");
    private final BaseResponse ORIGINAL_AMOUNT_INCORRECT = new BaseResponse("64", "Original amount incorrect");
    private final BaseResponse RESPONSE_RECEIVED_TOO_LATE = new BaseResponse("68", "Response received too late");
    private final BaseResponse INVALID_CREDIT_ACCOUNT = new BaseResponse("76", "Invalid Credit Account");
    private final BaseResponse INVALID_DEBIT_ACCOUNT = new BaseResponse("77", "Invalid Debit Account");
    private final BaseResponse INVALID_ACCOUNT = new BaseResponse("78", "Invalid Account");
    private final BaseResponse ERROR_INVALID_DATE_FORMAT = new BaseResponse("83", "Invalid date Format");
    private final BaseResponse FAILED_TO_CREATE_RECORD = new BaseResponse("88", "Failed to create record");

    private final BaseResponse DELETE_EXCEPTION = new BaseResponse("92", "Failed to delete record");

    private final BaseResponse ACTION_ALREADY_PERFORMED = new BaseResponse("93", "Action already performed on record");
    private final BaseResponse DUPLICATE_RECORD = new BaseResponse("94", "Duplicate record");





    private final BaseResponse FAILED_TO_UPDATE_RECORD = new BaseResponse("89", "Failed to update record");
    private final BaseResponse CUTOFF_IS_IN_PROCESS = new BaseResponse("90", "Cutoff is in process");
    private final BaseResponse ISSUER_OR_SWITCH_IS_INOPERATIVE = new BaseResponse("91", "Issuer or switch is inoperative");
    private final BaseResponse SYSTEM_MALFUNCTION = new BaseResponse("22", "System malfunction");
    private final BaseResponse SUCCESS_UPLOAD_SUBMITTED = new BaseResponse("97", "Failed to upload records.");
    private final BaseResponse ERROR_AUTHENTICATION_FAILED = new BaseResponse("100", "Authentication Failed");
    private final BaseResponse ERROR_FAILED_TO_GENERATE_OTP = new BaseResponse("101", "Failed to generate OTP");
    private final BaseResponse SUCCESS_OTP_SENT = new BaseResponse("00", "OTP is sent to your phone for authorization");
    private final BaseResponse BAD_REQUEST = new BaseResponse("106", "Bad Request");
    private final BaseResponse ACCESS_DENIED = new BaseResponse("107", "Access Denied");
    private final BaseResponse ERROR_INVALID_USERNAME = new BaseResponse("109", "Invalid Username");
    private final BaseResponse ERROR_INCORRECT_OLD_PASSWORD = new BaseResponse("110", "Incorrect Old Password");
    private final BaseResponse ERROR_PASSWORD_MISMATCH = new BaseResponse("111", "Password mismatch");
    private final BaseResponse ERROR_TOKEN_EXPIRED = new BaseResponse("112", "Token Expired");
    private final BaseResponse ERROR_AUTHORIZATION_TOKEN_MISSING = new BaseResponse("114", "Authorization Token Missing");
    private final BaseResponse INVALID_TOKEN = new BaseResponse("116", "Invalid Authorization Token");
    private final BaseResponse RECORD_ALREADY_EXISTS = new BaseResponse("117", "Record already exists");
    private final BaseResponse ERROR = new BaseResponse("99", "Something Went Wrong");

    // Private constructor to enforce singleton pattern
    private ResponseConstant() {}

    // Public getter methods for all response constants
    public BaseResponse getSUCCESS() { return SUCCESS; }
    public BaseResponse getREFER_TO_CARD_ISSUER() { return REFER_TO_CARD_ISSUER; }
    public BaseResponse getREFER_TO_CARD_ISSUERS_SPECIAL_CONDITIONS() { return REFER_TO_CARD_ISSUERS_SPECIAL_CONDITIONS; }
    public BaseResponse getINVALID_MERCHANT() { return INVALID_MERCHANT; }
    public BaseResponse getPICK_UP() { return PICK_UP; }
    public BaseResponse getDO_NOT_HONOR() { return DO_NOT_HONOR; }
    public BaseResponse getPICK_UP_CARD_SPECIAL_CONDITION() { return PICK_UP_CARD_SPECIAL_CONDITION; }
    public BaseResponse getHONOUR_WITH_IDENTIFICATION() { return HONOUR_WITH_IDENTIFICATION; }
    public BaseResponse getREQUEST_IN_PROGRESS() { return REQUEST_IN_PROGRESS; }
    public BaseResponse getAPPROVED_FOR_PARTIAL_AMOUNT() { return APPROVED_FOR_PARTIAL_AMOUNT; }
    public BaseResponse getAPPROVED_VIP() { return APPROVED_VIP; }
    public BaseResponse getINVALID_TRANSACTION() { return INVALID_TRANSACTION; }
    public BaseResponse getINVALID_AMOUNT() { return INVALID_AMOUNT; }
    public BaseResponse getINVALID_CARD_NUMBER_NO_SUCH_NUMBER() { return INVALID_CARD_NUMBER_NO_SUCH_NUMBER; }
    public BaseResponse getNO_SUCH_ISSUER() { return NO_SUCH_ISSUER; }
    public BaseResponse getAPPROVED_UPDATE_TRACK_3() { return APPROVED_UPDATE_TRACK_3; }
    public BaseResponse getCUSTOMER_CANCELLATION() { return CUSTOMER_CANCELLATION; }
    public BaseResponse getCUSTOMER_DISPUTE() { return CUSTOMER_DISPUTE; }
    public BaseResponse getRE_ENTER_TRANSACTION() { return RE_ENTER_TRANSACTION; }
    public BaseResponse getINVALID_RESPONSE() { return INVALID_RESPONSE; }
    public BaseResponse getNO_ACTION_TAKEN() { return NO_ACTION_TAKEN; }
    public BaseResponse getSUSPECTED_MALFUNCTION() { return SUSPECTED_MALFUNCTION; }
    public BaseResponse getACCOUNT_DELETED() { return DELETE_EXCEPTION; }

    public BaseResponse getUNACCEPTABLE_TRANSACTION_FEE() { return UNACCEPTABLE_TRANSACTION_FEE; }
    public BaseResponse getFORMAT_ERROR() { return FORMAT_ERROR; }
    public BaseResponse getCOMPLETED_PARTIALLY() { return COMPLETED_PARTIALLY; }
    public BaseResponse getEXPIRED_CARD() { return EXPIRED_CARD; }
    public BaseResponse getSUSPECTED_FRAUD() { return SUSPECTED_FRAUD; }
    public BaseResponse getRESTRICTED_CARD() { return RESTRICTED_CARD; }
    public BaseResponse getLOST_CARD() { return LOST_CARD; }
    public BaseResponse getNOT_SUFFICIENT_FUNDS() { return NOT_SUFFICIENT_FUNDS; }
    public BaseResponse getEXCEEDS_WITHDRAWAL_AMOUNT_LIMIT() { return EXCEEDS_WITHDRAWAL_AMOUNT_LIMIT; }
    public BaseResponse getSECURITY_VIOLATION() { return SECURITY_VIOLATION; }
    public BaseResponse getORIGINAL_AMOUNT_INCORRECT() { return ORIGINAL_AMOUNT_INCORRECT; }
    public BaseResponse getRESPONSE_RECEIVED_TOO_LATE() { return RESPONSE_RECEIVED_TOO_LATE; }
    public BaseResponse getINVALID_CREDIT_ACCOUNT() { return INVALID_CREDIT_ACCOUNT; }
    public BaseResponse getINVALID_DEBIT_ACCOUNT() { return INVALID_DEBIT_ACCOUNT; }
    public BaseResponse getINVALID_ACCOUNT() { return INVALID_ACCOUNT; }
    public BaseResponse getERROR_INVALID_DATE_FORMAT() { return ERROR_INVALID_DATE_FORMAT; }
    public BaseResponse getFAILED_TO_CREATE_RECORD() { return FAILED_TO_CREATE_RECORD; }
    public BaseResponse getFAILED_TO_UPDATE_RECORD() { return FAILED_TO_UPDATE_RECORD; }
    public BaseResponse getCUTOFF_IS_IN_PROCESS() { return CUTOFF_IS_IN_PROCESS; }
    public BaseResponse getISSUER_OR_SWITCH_IS_INOPERATIVE() { return ISSUER_OR_SWITCH_IS_INOPERATIVE; }
    public BaseResponse getSYSTEM_MALFUNCTION() { return SYSTEM_MALFUNCTION; }
    public BaseResponse getSUCCESS_UPLOAD_SUBMITTED() { return SUCCESS_UPLOAD_SUBMITTED; }
    public BaseResponse getERROR_AUTHENTICATION_FAILED() { return ERROR_AUTHENTICATION_FAILED; }
    public BaseResponse getERROR_FAILED_TO_GENERATE_OTP() { return ERROR_FAILED_TO_GENERATE_OTP; }
    public BaseResponse getSUCCESS_OTP_SENT() { return SUCCESS_OTP_SENT; }
    public BaseResponse getBAD_REQUEST() { return BAD_REQUEST; }
    public BaseResponse getACCESS_DENIED() { return ACCESS_DENIED; }
    public BaseResponse getERROR_INVALID_USERNAME() { return ERROR_INVALID_USERNAME; }
    public BaseResponse getERROR_INCORRECT_OLD_PASSWORD() { return ERROR_INCORRECT_OLD_PASSWORD; }
    public BaseResponse getERROR_PASSWORD_MISMATCH() { return ERROR_PASSWORD_MISMATCH; }
    public BaseResponse getERROR_TOKEN_EXPIRED() { return ERROR_TOKEN_EXPIRED; }
    public BaseResponse getUNABLE_TO_LOCATE_RECORD() { return UNABLE_TO_LOCATE_RECORD; }

    public BaseResponse getERROR_AUTHORIZATION_TOKEN_MISSING() { return ERROR_AUTHORIZATION_TOKEN_MISSING; }
    public BaseResponse getINVALID_TOKEN() { return INVALID_TOKEN; }
    public BaseResponse getRECORD_ALREADY_EXISTS() { return RECORD_ALREADY_EXISTS; }
    public BaseResponse getDUPLICATE_RECORD() { return DUPLICATE_RECORD; }
    public BaseResponse getERROR_ACTIVITY_ALREADY_PERFORMED() { return ACTION_ALREADY_PERFORMED; }
    public BaseResponse getERROR() { return ERROR; }

}