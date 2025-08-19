import java.util.Scanner;

public class APleaseBot {
    public static void main(String[] args) {

        String line = "________________________________________\n";

        String greeting =
                "Hello! I'm APleaseBot\n" +
                "What can I do for you?\n";

        String close = "Bye. Hope to see you again soon!\n";



        // Inputs
        System.out.println(line + greeting + line);

        Scanner scanner = new Scanner(System.in);


        while(true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println(line + close + line);
                break;
            } else {
                System.out.println(line + input + "\n" + line);
            };
        }
    }
}
