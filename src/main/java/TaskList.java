public class TaskList {
    private int itemCount;

    private Task[] tasks = new Task[100];

    public void add(Task task) {
        this.tasks[itemCount] = task;
        this.itemCount++;
    }

    public Task get(int index) {
        return this.tasks[index];
    }

    public int getItemCount() {
        return itemCount;
    }

    public String list() {
        if (this.itemCount < 1) throw new APleaseBotException("No items in list!");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.itemCount; i++) {
            sb.append(i + 1).append(". ").append(tasks[i]).append("\n");
        }
        return sb.toString();
    }
}
