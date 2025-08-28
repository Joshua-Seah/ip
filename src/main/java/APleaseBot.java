import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class APleaseBot {

    public static final String line = "________________________________________\n";

    public static final String greeting =
            "Hello! I'm APleaseBot\n" +
            "What can I do for you?\n";

    public static final String close = "Bye. Hope to see you again soon!\n";

    private static final File dir = new File("src/data");
    private static final String dataName = "APleaseBot.txt";
    private static File data;
    private static Path dataPath;

    public static void main(String[] args) throws APleaseBotException, FileNotFoundException {
        // Initialise list
        TaskList taskList = new TaskList();

        // Initialise input reader & data storage location
        System.out.println(line + greeting + line);
        Scanner scanner = new Scanner(System.in);

        // Find the storage file else initialise it
        if (!dir.exists()) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                System.err.println("Error creating directory: " + e.getMessage());
            }
        }
        File[] files = dir.listFiles();
        if (files == null) {
            try {
                File newFile = new File(dir, dataName);
                newFile.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating data file: " + e.getMessage());
            }
        }
        for (File file : files) {
            if (file.isFile() && file.getName().equals(dataName)) {
                data = new File(dir, dataName);
                dataPath = Paths.get(data.getPath());
            }
        }

        // Initialise instance memory
        List<String> entries;
        try {
            entries = Files.readAllLines(dataPath);
        } catch (IOException e) {
            throw new APleaseBotException("Err reading data file: " + e.getMessage());
        }

        // Load data onto memory
        if (!entries.isEmpty()) {
            taskList.loadData(entries);
        }


        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println(line + close + line);

            }
            try {
                Command command = Parser.parse(input, dataPath);
                command.execute(taskList);
                if (command instanceof ByeCommand) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(line + "Something went wrong!\n" + e.getMessage() + "\n" + line);
            } finally {
                System.out.println(line + greeting + line);
            }
        }

        scanner.close();

    }
}

