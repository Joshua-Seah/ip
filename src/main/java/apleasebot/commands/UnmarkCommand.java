package apleasebot.commands;

import apleasebot.exceptions.IllegalBotArgumentException;
import apleasebot.tasks.TaskList;
import apleasebot.ui.APleaseBot;

/**
 * Encapsulates the logic for when a user says unmark
 */
public class UnmarkCommand implements Command {
    // fields
    private final String input;


    // constructor
    public UnmarkCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks) {
        if (input.length() < 7) {
            throw new IllegalBotArgumentException("No argument found!", input); // no argument
        }
        if (!isInt(input, 7)) {
            throw new IllegalBotArgumentException("Argument is not integer!" , input); // non-integer argument
        }

        int num = Integer.parseInt(input.substring(7));

        if (num < 1 || num > tasks.getItemCount()) {
            throw new IllegalBotArgumentException("Item out of bounds!", input); // index out of bounds of list
        }
        tasks.get(num - 1).markUndone();

        System.out.println(
                APleaseBot.LINE
                        + "Ok! I've marked this task as not done yet:\n"
                        + tasks.get(num - 1).toString() + "\n"
                        + APleaseBot.LINE
        );
    }
}
