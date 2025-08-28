import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ByeCommand  implements Command {
    // fields
    private Path dataPath;

    // constructor
    public ByeCommand(Path dataPath) {
        this.dataPath = dataPath;
    }

    public void execute(TaskList taskList) {
        ArrayList<String> entries = new ArrayList<>();
        int len = taskList.getItemCount();
        for (int i = 0; i < len; i++) {
            entries.add(taskList.get(i).translate());
        }
        try{
            Files.write(dataPath, entries);
        } catch (IOException e) {
            throw new DataException("Err writing file: " + e);
        }
        
        System.out.println(APleaseBot.line + APleaseBot.close + APleaseBot.line);
    }
}
