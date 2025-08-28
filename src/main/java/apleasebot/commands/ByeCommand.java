package apleasebot.commands;

import apleasebot.ui.Storage;
import apleasebot.tasks.TaskList;
import apleasebot.ui.APleaseBot;

public class ByeCommand  implements Command {
    // fields
    Storage storage;

    // constructor
    public ByeCommand(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void execute(TaskList taskList) {
        storage.close(taskList);
        System.out.println(APleaseBot.line + APleaseBot.close + APleaseBot.line);
    }
}
