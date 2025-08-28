import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ByeCommand  implements Command {
    // fields
    Storage storage;

    // constructor
    public ByeCommand(Storage storage) {
        this.storage = storage;
    }

    public void execute(TaskList taskList) {
        storage.close(taskList);
        System.out.println(APleaseBot.line + APleaseBot.close + APleaseBot.line);
    }
}
