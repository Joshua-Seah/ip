import java.util.Scanner;

public class APleaseBot {

    private static boolean isInt(String s, int bIdx) {
        int x = 0;
        try {
            x = Integer.parseInt(s.substring(bIdx));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws APleaseBotException {

        String line = "________________________________________\n";

        String greeting =
                "Hello! I'm APleaseBot\n" +
                        "What can I do for you?\n";

        String close = "Bye. Hope to see you again soon!\n";

        // Initialise list
        Task[] taskList = new Task[100];
        int itemCount = 0;



        // Inputs
        System.out.println(line + greeting + line);

        Scanner scanner = new Scanner(System.in);



        while(true) {
            String input = scanner.nextLine();

            try {
                if (input.equals("bye")) {
                    System.out.println(line + close + line);
                    break;
                } else if (input.equals("help")) {
                    System.out.println(
                            "List of commands\n" +
                            "help - list commands\n" +
                            "bye - close program\n" +
                            "list - list tasks\n" +
                            "mark - mark <task-number> - marks task as done\n" +
                            "unmark - unmark <task-number> - marks task as not done\n" +
                            "todo - todo <task-name> - creates a task with no deadline\n" +
                            "deadline - deadline <task-name> \\by <string deadline>\n" +
                            "event - event <event-name> \\from <string time> \\to <string time>\n"
                    );
                    continue;
                }
                if (input.equals("list")) {
                    if (itemCount < 1) throw new APleaseBotException("No items in list!");
                    String output = "";
                    for (int j = 0; j < itemCount; j++) {
                        output += j + 1 + ". " + taskList[j].toString() + "\n";
                    }
                    System.out.println(line + output + line);
                } else if (input.startsWith("mark")) {
                    if (input.length() < 5) throw new IllegalBotArgumentException("No argument found!", input); // no argument
                    if (!isInt(input, 5)) throw new IllegalBotArgumentException("Argument is not integer!", input); // non-integer argument

                    int num = Integer.parseInt(input.substring(5));

                    if (num < 1 || num > itemCount) throw new IllegalBotArgumentException("Item out of bounds!", input); // array out of bounds
                    taskList[num - 1].markDone();
                    System.out.println(
                            line +
                                    "Nice! I've marked this task as done:\n" +
                                    taskList[num - 1].toString() + "\n" +
                                    line
                    );
                } else if (input.startsWith("unmark")) {
                    // Potential errors :
                    // array out of bounds
                    // non-integer argument
                    if (input.length() < 7) throw new IllegalBotArgumentException("No argument found!", input); // no argument
                    if (!isInt(input, 7)) throw new IllegalBotArgumentException("Argument is not integer!" , input); // non-integer argument

                    int num = Integer.parseInt(input.substring(7));

                    if (num < 1 || num > itemCount) throw new IllegalBotArgumentException("Item out of bounds!", input); // array out of bounds
                    taskList[num - 1].markUndone();
                    System.out.println(
                            line +
                                    "Ok! I've marked this task as not done yet:\n" +
                                    taskList[num - 1].toString() + "\n" +
                                    line
                    );
                } else if (input.startsWith("todo")) {
                    if (input.length() < 5) throw new IllegalBotArgumentException("No argument found!", input); // no argument

                    String task = input.substring(5);
                    taskList[itemCount] = new Task(task, Task.TODO);
                    itemCount++;
                    System.out.println(
                            line +
                                    "Got it. I've added this task: \n" +
                                    "  " + taskList[itemCount - 1].toString() + "\n" +
                                    "Now you have " + itemCount + " tasks in the list" + "\n" +
                                    line
                    );
                } else if (input.startsWith("deadline")) {
                    if (input.length() < 9) throw new IllegalBotArgumentException("No argument found!", input); // no argument

                    String[] sub = input.substring(9).split("\\\\by"); // solution to backslash character found using Google search
                    if (sub.length != 2) throw new IllegalBotArgumentException("Wrong number of arguments!", input);

                    String task = sub[0];
                    String deadline = sub[1];
                    if (task.isEmpty()) throw new IllegalBotArgumentException("No Task stated:", input);
                    if (deadline.isEmpty()) throw new IllegalBotArgumentException("No Deadline stated:", input);

                    taskList[itemCount] = new Task(task, Task.DEADLINE, deadline);
                    itemCount++;
                    System.out.println(
                            line +
                                    "Got it. I've added this task: \n" +
                                    "  " + taskList[itemCount - 1].toString() + "\n" +
                                    "Now you have " + itemCount + " tasks in the list" + "\n" +
                                    line
                    );
                } else if (input.startsWith("event")) {
                    if (input.length() < 6) throw new IllegalBotArgumentException("No argument found!", input); // no argument

                    String[] sub = getStrings(input); // function to group multiple error-catching statements auto-generated by IntelliJ IDEA IDE


                    String task = sub[0];
                    if (task.isEmpty()) throw new IllegalBotArgumentException("No Task stated:", input);

                    String startTime = sub[1].substring(5);
                    if (startTime.isEmpty()) throw new IllegalBotArgumentException("No 'from' string stated:", input);
                    System.out.println("we got here");
                    String endTime = sub[2].substring(3);
                    if (endTime.isEmpty()) throw new IllegalBotArgumentException("No 'to' string stated:", input);

                    taskList[itemCount] = new Task(task, Task.EVENT, startTime, endTime);
                    itemCount++;
                    System.out.println(
                            line +
                                    "Got it. I've added this task: \n" +
                                    "  " + taskList[itemCount - 1].toString() + "\n" +
                                    "Now you have " + itemCount + " tasks in the list" + "\n" +
                                    line
                    );
                } else {
                    throw new UnknownCommandException(input);
                }
                ;
            } catch (Exception e) {
                System.out.println(line + "Something went wrong!\n" + e.getMessage() + "\n" + line);
            } finally {
                if (!(input.equals("bye"))) System.out.println(line + greeting + line);
            }
        }
    }

    private static String[] getStrings(String input) {
        String[] sub = input.substring(6).split("\\\\"); // solution to backslash character found using Google search
        if (sub.length != 3) throw new IllegalBotArgumentException("Wrong number of arguments!", input);
        if (!sub[1].startsWith("from")) throw new IllegalBotArgumentException("No 'from' argument!", input);
        if (sub[1].length() < 5) throw new IllegalBotArgumentException("No argument found!", input); // no argument
        if (!sub[2].startsWith("to")) throw new IllegalBotArgumentException("No 'to' argument!", input);
        if (sub[2].length() < 3) throw new IllegalBotArgumentException("No argument found!", input); // no argument
        return sub;
    }
}

