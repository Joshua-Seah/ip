public class DataException extends APleaseBotException {
    public DataException(String message) {
        super("Issue with data file: " + message);
    }
}
