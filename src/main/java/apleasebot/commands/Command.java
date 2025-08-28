package apleasebot.commands;

import apleasebot.tasks.TaskList;

public interface Command {
    void execute(TaskList tasks);

    default boolean isInt(String s, int bIdx) {
        int x = 0;
        try {
            x = Integer.parseInt(s.substring(bIdx));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
