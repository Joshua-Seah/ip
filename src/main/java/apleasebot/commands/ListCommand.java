package apleasebot.commands;

import apleasebot.exceptions.DataException;
import apleasebot.tasks.TaskList;
import apleasebot.ui.APleaseBot;

public class ListCommand implements Command {

    @Override
    public void execute(TaskList tasks) {
        if (tasks.getItemCount() < 1) throw new DataException("No items loaded/stored yet");
        System.out.println(APleaseBot.line + tasks.list() + APleaseBot.line);
    }
}
