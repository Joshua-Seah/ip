import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        this.tasks.add(task);
    }

    public void remove(int index) {
        this.tasks.remove(index);
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    public int getItemCount() {
        return this.tasks.size();
    }

    public String list() {
        if (this.tasks.isEmpty()) throw new APleaseBotException("No items in list!");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getItemCount(); i++) {
            sb.append(i + 1).append(". ").append(this.get(i)).append("\n");
        }
        return sb.toString();
    }
}
