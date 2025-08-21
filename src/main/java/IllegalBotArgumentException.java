public class IllegalBotArgumentException extends APleaseBotException {
    public IllegalBotArgumentException(String message, String input) {
        super(message + "\n" + "Use 'help' to see list of recognised words and arguments needed" + "\nYour input:\n" + input + "\n");
    }
}
