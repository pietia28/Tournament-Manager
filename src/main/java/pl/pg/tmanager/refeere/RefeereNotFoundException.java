package pl.pg.tmanager.refeere;

public class RefeereNotFoundException extends RuntimeException{
    public RefeereNotFoundException() {
    }

    public RefeereNotFoundException(String message) {
        super(message);
    }

    public RefeereNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RefeereNotFoundException(Throwable cause) {
        super(cause);
    }

    public RefeereNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
