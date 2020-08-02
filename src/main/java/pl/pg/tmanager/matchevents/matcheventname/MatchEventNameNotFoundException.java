package pl.pg.tmanager.matchevents.matcheventname;

public class MatchEventNameNotFoundException extends RuntimeException{
    public MatchEventNameNotFoundException() {
    }

    public MatchEventNameNotFoundException(String message) {
        super(message);
    }

    public MatchEventNameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatchEventNameNotFoundException(Throwable cause) {
        super(cause);
    }

    public MatchEventNameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
