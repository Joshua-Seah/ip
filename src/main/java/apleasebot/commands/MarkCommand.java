package apleasebot.commands;

import apleasebot.exceptions.IllegalBotArgumentException;
import apleasebot.tasks.TaskList;
import apleasebot.ui.APleaseBot;

/**
 * Encapsulates the logic for when the user says mark
 */
public class MarkCommand implements Command {
    // fields
    private final String input;

    // constructor
    public MarkCommand(String input) {
        this.input = input;
    }

    @Override
    public String execute(TaskList tasks) {
        if (input.length() < 5) {
            throw new IllegalBotArgumentException("No argument found!", input); // no argument
        }
        if (!isInt(input, 5)) {
            throw new IllegalBotArgumentException("Argument is not integer!", input); // non-integer argument
        }

        int num = Integer.parseInt(input.substring(5));

        if (num < 1 || num > tasks.getItemCount()) {
            throw new IllegalBotArgumentException("Item out of bounds!", input); // index out of bounds of list
        }

        tasks.getTask(num - 1).markDone();

        return APleaseBot.LINE
                + "Nice! I've marked this task as done:\n"
                + tasks.getTask(num - 1).toString() + "\n"
                + APleaseBot.LINE;
    }
}
