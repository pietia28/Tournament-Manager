package pl.pg.tmanager.matchevents.matchevent;

public class MatchEventNotFoundException extends RuntimeException{
    public MatchEventNotFoundException() {
    }

    public MatchEventNotFoundException(String message) {
        super(message);
    }

    public MatchEventNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatchEventNotFoundException(Throwable cause) {
        super(cause);
    }

    public MatchEventNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
