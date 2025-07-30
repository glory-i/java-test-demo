package qucoon.mod.SpringServerless.utility.exception;


public class CustomExceptions {

    public static class AccountNotActiveException extends RuntimeException {
        public AccountNotActiveException(String message) {
            super(message);
        }
    }

    public static class OtpExpiredException extends RuntimeException {
        public OtpExpiredException(String message) {
            super(message);
        }
    }

    public static class UnableToLocateRecordException extends RuntimeException {
        public UnableToLocateRecordException(String message) {
            super(message);
        }
    }

    public static class DuplicateItemException extends RuntimeException {
        public DuplicateItemException(String message) {
            super(message);
        }
    }




    public static class InvalidOtpException extends RuntimeException {
        public InvalidOtpException(String message) {
            super(message);
        }
    }

    public static class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }
    }

    public static class InvalidRouteException extends RuntimeException {
        public InvalidRouteException(String message) {
            super(message);
        }
    }

    public static class ApiErrorException extends RuntimeException {
        public ApiErrorException(String message) {
            super(message);
        }
    }

    public static class IncorrectPasswordException extends RuntimeException {
        public IncorrectPasswordException(String message) {
            super(message);
        }
    }

    public static class BadConnectionException extends RuntimeException {
        public BadConnectionException(String message) {
            super(message);
        }
    }

    public static class RecordAlreadyExistException extends RuntimeException {
        public RecordAlreadyExistException(String message) {
            super(message);
        }
    }

    public static class AccessNotAllowedException extends RuntimeException {
        public AccessNotAllowedException(String message) {
            super(message);
        }
    }

    public static class FailedToCreateRecordException extends RuntimeException {
        public FailedToCreateRecordException(String message) {
            super(message);
        }
    }

    public static class FailedToUpdateRecordException extends RuntimeException {
        public FailedToUpdateRecordException(String message) {
            super(message);
        }
    }

    public static class SuspectedMalfunctionException extends RuntimeException {
        public SuspectedMalfunctionException(String message) {
            super(message);
        }
    }

    public static class AccountDeletedException extends RuntimeException {
        public AccountDeletedException(String message) {
            super(message);
        }
    }

    public static class UnauthorizedAccessException extends RuntimeException {
        public UnauthorizedAccessException(String message) {
            super(message);
        }
    }

    public static class InvalidPathException extends RuntimeException {
        public InvalidPathException(String message) {
            super(message);
        }
    }

    public static class InvalidTransactionException extends RuntimeException {
        public InvalidTransactionException(String message) {
            super(message);
        }
    }

    public static class NotSufficientFundsException extends RuntimeException {
        public NotSufficientFundsException(String message) {
            super(message);
        }
    }

    public static class DuplicateTransactionException extends RuntimeException {
        public DuplicateTransactionException(String message) {
            super(message);
        }
    }

    public static class HonourWithIdentificationException extends RuntimeException {
        public HonourWithIdentificationException(String message) {
            super(message);
        }
    }

    public static class ActivityAlreadyPerformedException extends RuntimeException {
        public ActivityAlreadyPerformedException(String message) {
            super(message);
        }
    }

    public static class FailedToUpdateRecord extends RuntimeException {
        public FailedToUpdateRecord(String message) {
            super(message);
        }
    }

    public static class FailedToCreateRecord extends RuntimeException {
        public FailedToCreateRecord(String message) {
            super(message);
        }
    }

}


