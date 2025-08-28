package apleasebot.exceptions;

public class UnknownCommandException extends APleaseBotException {
    public UnknownCommandException(String message) {
        super("I am not sure what you mean by: " + "\"" + message + "\"" + "\n" + "Use 'help' to see list of recognised words and arguments needed");
    }
}
