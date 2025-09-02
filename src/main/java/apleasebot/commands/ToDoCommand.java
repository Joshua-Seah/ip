package apleasebot.commands;

import apleasebot.exceptions.IllegalBotArgumentException;
import apleasebot.tasks.Task;
import apleasebot.tasks.TaskList;
import apleasebot.tasks.Todo;
import apleasebot.ui.APleaseBot;

/**
 * Encapsulates the logic for when a user says todo
 */
public class ToDoCommand implements Command {
    // fields
    private final String input;

    // constructor
    public ToDoCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks) {
        if (input.length() < 5) {
            throw new IllegalBotArgumentException("No argument found!", input); // no argument
        }

        String task = input.substring(5);

        Task newTask = new Todo(task, false);
        tasks.addTask(newTask);

        System.out.println(
                APleaseBot.LINE
                        + "Got it. I've added this task:\n"
                        + "  " + newTask.toString() + "\n"
                        + "Now you have " + tasks.getItemCount() + " tasks in the list" + "\n"
                        + APleaseBot.LINE
        );
    }
}
