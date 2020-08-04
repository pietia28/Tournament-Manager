package pl.pg.tmanager.referee;

public class RefereeNotFoundException extends RuntimeException{
    public RefereeNotFoundException() {
    }

    public RefereeNotFoundException(String message) {
        super(message);
    }

    public RefereeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefereeNotFoundException(Throwable cause) {
        super(cause);
    }

    public RefereeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
