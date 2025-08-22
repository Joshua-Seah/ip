public class HelpCommand  implements Command {
    @Override
    public void execute(TaskList tasks) {
        System.out.println(
                APleaseBot.line +
                "List of commands\n" +
                "help - list commands\n" +
                "bye - close program\n" +
                "list - list tasks\n" +
                "mark <task-number>\n" +
                "unmark <task-number>\n" +
                "todo <task-name>\n" +
                "deadline <task-name> \\by <deadline>\n" +
                "event <event-name> \\from <time> \\to <time>\n" +
                APleaseBot.line
        );
    }
}

