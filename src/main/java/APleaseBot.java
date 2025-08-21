import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class APleaseBot {

    public static class Task {
        // Fields
        protected String name;
        protected boolean done;



        // constructor
        public Task(String name) {
            this.name = name;
            this.done = false;
        }



        // methods
        public void markDone() {
            this.done = true;
        }

        public String toString() {
            return (done ? "[X]" : "[ ]") + " " + name;
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
                    output += j+1 + ". " + taskList[j] + "\n";
                }
                System.out.println(line + output + line);
            } else {
                taskList[itemCount] = new Task(input);
                itemCount++;
                System.out.println(line + "added: " + input + "\n" + line);
            };
        }
    }
}
