package pl.pg.tmanager.tournament;

public class TournamentNotFoundException extends RuntimeException{
    public TournamentNotFoundException() {
    }

    public TournamentNotFoundException(String message) {
        super(message);
    }

    public TournamentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TournamentNotFoundException(Throwable cause) {
        super(cause);
    }

    public TournamentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
