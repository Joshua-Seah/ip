package apleasebot.commands;

import apleasebot.exceptions.DataException;
import apleasebot.tasks.TaskList;
import apleasebot.ui.APleaseBot;

/**
 * Encapsulates the logic for when the user says find ...
 */
public class FindCommand implements Command {
    private String input;

    public FindCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks) {
        String keyphrase = input.substring(5);
        TaskList filteredTasks = tasks.search(keyphrase);

        if (tasks.getItemCount() < 1) {
            throw new DataException("No items loaded/stored yet");
        }
        System.out.println(APleaseBot.LINE + filteredTasks.list() + APleaseBot.LINE);
    }
}
