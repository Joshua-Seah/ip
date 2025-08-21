import java.util.Scanner;

public class APleaseBot {

    public static final String line = "________________________________________\n";

    public static final String greeting =
            "Hello! I'm APleaseBot\n" +
                    "What can I do for you?\n";

    public static final String close = "Bye. Hope to see you again soon!\n";

    public static void main(String[] args) throws APleaseBotException {
        // Initialise list
        TaskList taskList = new TaskList();

        // Initialise input reader
        System.out.println(line + greeting + line);
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println(line + close + line);
                break;
            }
            try {
                Command command = Parser.parse(input);
                command.execute(taskList);
            } catch (Exception e) {
                System.out.println(line + "Something went wrong!\n" + e.getMessage() + "\n" + line);
            } finally {
                System.out.println(line + greeting + line);
            }
        }

    }
}

