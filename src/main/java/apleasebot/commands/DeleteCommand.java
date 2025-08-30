package apleasebot.commands;

import apleasebot.exceptions.IllegalBotArgumentException;
import apleasebot.tasks.TaskList;
import apleasebot.ui.APleaseBot;

/**
 * Encapsulates the logic when a user says delete
 */
public class DeleteCommand implements Command {
    // fields
    private String input;

    // constructor
    public DeleteCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks) {
        if (input.length() < 7) {
            throw new IllegalBotArgumentException("No argument found!", input); // no argument
        }
        if (!isInt(input, 7)) {
            throw new IllegalBotArgumentException("Argument is not integer!", input); // non-integer argument
        }

        int num = Integer.parseInt(input.substring(7));
        if (num < 1 || num > tasks.getItemCount()) {
            throw new IllegalBotArgumentException("Item out of bounds!", input); // array out of bounds
        }

        String removed = tasks.get(num - 1).toString();
        tasks.remove(num - 1);

        System.out.println(
                APleaseBot.LINE
                        + "Got it. I've removed this task: \n"
                        + "  " + removed + "\n"
                        + "Now you have " + tasks.getItemCount() + " tasks in the list" + "\n"
                        + APleaseBot.LINE
        );
    }
}
