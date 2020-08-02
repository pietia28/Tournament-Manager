package pl.pg.tmanager.manager;

public class ManagerNotFoundException extends RuntimeException{
    public ManagerNotFoundException() {
    }

    public ManagerNotFoundException(String message) {
        super(message);
    }

    public ManagerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerNotFoundException(Throwable cause) {
        super(cause);
    }

    public ManagerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
