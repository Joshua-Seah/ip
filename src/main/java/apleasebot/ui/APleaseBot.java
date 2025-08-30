package apleasebot.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import apleasebot.commands.ByeCommand;
import apleasebot.commands.Command;
import apleasebot.exceptions.APleaseBotException;
import apleasebot.parser.Parser;
import apleasebot.tasks.TaskList;

/**
 * Entry point for the bot program
 * Runs the logic for combining all the different classes and simulating the bot
 */
public class APleaseBot {

    public static final String LINE = "________________________________________\n";

    public static final String GREETING = "Hello! I'm APleaseBot\n" + "What can I do for you?\n";

    public static final String CLOSE = "Bye. Hope to see you again soon!\n";

    private final Storage storage;
    private TaskList taskList;
    private final Ui ui;

    /**
     * Constructor for the APleaseBot class
     * @param path String file path to the storage file
     */
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

    /**
     * Function that is run in order to start the bot
     */
    public void run() {

        Scanner scanner = ui.start();

        while (true) {
            System.out.println(LINE + GREETING + LINE);
            String input = scanner.nextLine();
            try {
                Command command = Parser.parse(input, storage);
                command.execute(taskList);
                if (command instanceof ByeCommand) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(LINE + "Something went wrong!\n" + e.getMessage() + "\n" + LINE);
            }
        }
        ui.close();
    }

    public static void main(String[] args) throws APleaseBotException, FileNotFoundException {
        new APleaseBot("src/data/APleaseBot.txt").run();
    }
}

