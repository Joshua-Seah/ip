public class ListCommand implements Command {
    @Override
    public void execute(TaskList tasks) {
        System.out.println(APleaseBot.line + tasks.list() + APleaseBot.line);
    }
}
