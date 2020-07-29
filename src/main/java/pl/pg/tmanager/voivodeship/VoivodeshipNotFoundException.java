package pl.pg.tmanager.voivodeship;

public class VoivodeshipNotFoundException extends RuntimeException{
    public VoivodeshipNotFoundException() {
    }

    public VoivodeshipNotFoundException(String message) {
        super(message);
    }

    public VoivodeshipNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoivodeshipNotFoundException(Throwable cause) {
        super(cause);
    }

    public VoivodeshipNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
