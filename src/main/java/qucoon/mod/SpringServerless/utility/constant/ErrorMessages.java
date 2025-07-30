package qucoon.mod.SpringServerless.utility.constant;


/**
 * Centralized class for managing error messages.
 */
public final class ErrorMessages {

    public static final String USER_NOT_FOUND = "User record not found.";
    public static final String RECORD_NOT_FOUND = "Record not found.";
    public static final String RECORD_NOT_UPDATED = "Record not processed.";
    public static final String OTP_EXPIRED = "OTP expired. Please request a new one.";
    public static final String INVALID_CREDENTIALS = "Invalid username or password.";
    public static final String ACCESS_DENIED = "Access denied. You do not have permission.";
    public static final String RECORD_ALREADY_EXISTS = "The record already exists.";
    public static final String INSUFFICIENT_FUNDS = "Not sufficient funds available.";
    public static final String DUPLICATE_TRANSACTION = "Duplicate transaction detected.";
    public static final String INVALID_TRANSACTION = "Invalid transaction request.";
    public static final String ACCOUNT_DELETED = "This account has been deleted or suspended.";
    public static final String AUTHORIZATION_FAILED = "Authorization failed. Invalid token.";
    public static final String BAD_REQUEST = "Bad request. Please check your input.";
    public static final String SYSTEM_ERROR = "Something went wrong. Please try again later.";

    private ErrorMessages() {
        // Private constructor to prevent instantiation
    }
}

