package pl.pg.tmanager.match;

public class MatchNotFoundExeption extends RuntimeException{
    public MatchNotFoundExeption() {
    }

    public MatchNotFoundExeption(String message) {
        super(message);
    }

    public MatchNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public MatchNotFoundExeption(Throwable cause) {
        super(cause);
    }

    public MatchNotFoundExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
