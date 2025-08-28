import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

public class ToDoCommand implements Command{
    // fields
    String input;

    // constructor
    public ToDoCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks) {
        if (input.length() < 5) throw new IllegalBotArgumentException("No argument found!", input); // no argument

        String task = input.substring(5);

        Task newTask = new Todo(task, false);
        tasks.add(newTask);

        System.out.println(
                APleaseBot.line +
                "Got it. I've added this task:\n" +
                "  " + newTask.toString() + "\n" +
                "Now you have " + tasks.getItemCount() + " tasks in the list" + "\n" +
                APleaseBot.line
        );
    }
}
