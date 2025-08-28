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

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    // constructor
    public APleaseBot(String path) {
        ui = new Ui();
        storage = new Storage(path);
        try {
            taskList = new TaskList(storage.load());
        } catch (APleaseBotException e) {
            ui.showLoadingError();
            taskList = new TaskList();
        }
    }

    // methods
    public void run() {

        Scanner scanner = ui.start();

        while (true) {
            System.out.println(line + greeting + line);
            String input = scanner.nextLine();
            try {
                Command command = Parser.parse(input, storage);
                command.execute(taskList);
                if (command instanceof ByeCommand) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(line + "Something went wrong!\n" + e.getMessage() + "\n" + line);
            }
        }
        ui.close();
    }

    public static void main(String[] args) throws APleaseBotException, FileNotFoundException {
        new APleaseBot("src/data/APleaseBot.txt").run();
    }
}

