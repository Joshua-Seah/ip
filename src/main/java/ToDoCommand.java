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
        tasks.add(new Todo(task));
        System.out.println(
                APleaseBot.line +
                "Got it. I've added this task:\n" +
                "  " + tasks.get(tasks.getItemCount() - 1).toString() + "\n" +
                "Now you have " + tasks.getItemCount() + " tasks in the list" + "\n" +
                APleaseBot.line
        );
    }
}
