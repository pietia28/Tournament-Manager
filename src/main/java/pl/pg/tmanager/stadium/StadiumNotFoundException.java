package pl.pg.tmanager.stadium;

public class StadiumNotFoundException extends RuntimeException{
    public StadiumNotFoundException() {
    }

    public StadiumNotFoundException(String message) {
        super(message);
    }

    public StadiumNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StadiumNotFoundException(Throwable cause) {
        super(cause);
    }

    public StadiumNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
