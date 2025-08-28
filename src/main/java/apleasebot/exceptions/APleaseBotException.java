package apleasebot.exceptions;

public class APleaseBotException extends RuntimeException {
    public APleaseBotException(String message) {
        super("APleaseBot error: "  + message);
    }
}
