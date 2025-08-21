public class APleaseBotException extends RuntimeException {
    public APleaseBotException(String message) {
        super("Duke error: "  + message);
    }
}
