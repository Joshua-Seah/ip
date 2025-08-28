import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

public class DeadlineCommand implements Command{
    // fields
    private String input;

    // constructor
    public DeadlineCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks) {
        if (input.length() < 9) throw new IllegalBotArgumentException("No argument found!", input); // no argument

        String[] sub = input.substring(9).split("\\\\by"); // solution to backslash character found using Google search
        if (sub.length != 2) throw new IllegalBotArgumentException("Wrong number of arguments!", input);

        String task = sub[0];
        String deadline = sub[1];
        if (task.isEmpty()) throw new IllegalBotArgumentException("No Task stated:", input);
        if (deadline.isEmpty()) throw new IllegalBotArgumentException("No Deadline stated:", input);

        Task newTask = new Deadline(task, false, deadline);
        tasks.add(newTask);

        System.out.println(
                APleaseBot.line +
                "Got it. I've added this task:\n" +
                "  " + newTask + "\n" +
                "Now you have " + tasks.getItemCount() + " tasks in the list" + "\n" +
                APleaseBot.line
        );
    }
}
