import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APleaseBot {

    public static class Task {
        // Fields
        protected String name;
        protected boolean done;
        protected int type;
        protected String deadline;
        protected String startTime;

        static final int TODO=0, DEADLINE=1, EVENT=2;


        // constructor
        public Task(String name, int type) {
            this.name = name;
            this.done = false;
            this.type = type;
        }

        public Task(String name, int type, String deadline) {
            this.name = name;
            this.done = false;
            this.type = type;
            this.deadline = deadline;
        }

        public Task(String name, int type, String startTime, String endTime) {
            this.name = name;
            this.done = false;
            this.type = type;
            this.startTime = startTime;
            this.deadline = endTime;
        }



        // methods
        public void markDone() {
            this.done = true;
        }

        public void markUndone() {
            this.done = false;
        }

        public String toString() {
            String t = "";
            String suffix = "";
            boolean sNeeded = false;
            switch (type) {
                case TODO:
                    t = "T";
                    break;
                case DEADLINE:
                    t = "D";
                    sNeeded = true;
                    suffix = "by: " + this.deadline;
                    break;
                case EVENT:
                    t = "E";
                    sNeeded = true;
                    suffix = "from: " + this.startTime + " to: " + this.deadline;
                    break;
                default:
                    t ="err";
                    break;
            }
            return  "[ " + t + " ]" +
                    (done ? "[X]" : "[ ]") + " " +
                    name +
                    (sNeeded ? "(" + suffix + ")" : "");
        }
    }

    public static void main(String[] args) {

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

            if (input.equals("bye")) {
                System.out.println(line + close + line);
                break;
            } else if(input.equals("list")) {
                String output = "";
                for (int j = 0; j < itemCount; j++) {
                    output += j+1 + ". " + taskList[j].toString() + "\n";
                }
                System.out.println(line + output + line);
            } else if(input.startsWith("mark")) {
                // Potential errors :
                // array out of bounds
                // non-integer argument
                int num = Integer.parseInt(input.substring(5));
                taskList[num - 1].markDone();
                System.out.println(
                        line +
                        "Nice! I've marked this task as done:\n" +
                        taskList[num - 1].toString() + "\n" +
                        line
                );
            } else if(input.startsWith("unmark")) {
                // Potential errors :
                // array out of bounds
                // non-integer argument
                int num = Integer.parseInt(input.substring(7));
                taskList[num - 1].markUndone();
                System.out.println(
                        line +
                        "Ok! I've marked this task as not done yet:\n" +
                        taskList[num - 1].toString() + "\n" +
                        line
                );
            } else if(input.startsWith("todo")) {
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
            } else if(input.startsWith("deadline")) {
                String[] sub = input.substring(9).split("\\\\by"); // solution to backslash character found using Google search
                String task = sub[0];
                String deadline = sub[1];
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
                String[] sub = input.substring(6).split("\\\\"); // solution to backslash character found using Google search
                String task = sub[0];
                String startTime = sub[1].substring(5);
                String endTime = sub[2].substring(3);
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
                System.out.println("What?");
            };
        }
    }
}

