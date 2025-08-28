import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

public class MarkCommand implements Command{
    // fields
    String input;

    // constructor
    public MarkCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks) {
        if (input.length() < 5) throw new IllegalBotArgumentException("No argument found!", input); // no argument
        if (!isInt(input, 5)) throw new IllegalBotArgumentException("Argument is not integer!", input); // non-integer argument

        int num = Integer.parseInt(input.substring(5));

        if (num < 1 || num > tasks.getItemCount())
            throw new IllegalBotArgumentException("Item out of bounds!", input); // index out of bounds of list

        tasks.get(num - 1).markDone();

        System.out.println(
                APleaseBot.line +
                "Nice! I've marked this task as done:\n" +
                tasks.get(num - 1).toString() + "\n" +
                APleaseBot.line
        );
    }
}
