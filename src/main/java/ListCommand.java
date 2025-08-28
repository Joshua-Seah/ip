import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

public class ListCommand implements Command {

    @Override
    public void execute(TaskList tasks) {
        if (tasks.getItemCount() < 1) throw new DataException("No items loaded/stored yet");
        System.out.println(APleaseBot.line + tasks.list() + APleaseBot.line);
    }
}
