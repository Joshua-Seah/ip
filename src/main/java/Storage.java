import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private final File dataFile;
    private final Path dataPath;

    public Storage(String path) {
        this.dataFile = new File(path);
        File dir = dataFile.getParentFile();

        // Make directory if missing
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new APleaseBotException("Error creating directory: " + dir.getPath());
            }
        }

        // Make file if missing
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                throw new APleaseBotException("Error creating data file: " + e.getMessage());
            }
        }

        this.dataPath = Paths.get(dataFile.getPath());
    }

    public List<String> load() {
        try {
            return Files.readAllLines(dataPath);
        } catch (IOException e) {
            throw new APleaseBotException("Err reading data file: " + e.getMessage());
        }
    }

    public void close(TaskList taskList) {
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
    }
}
