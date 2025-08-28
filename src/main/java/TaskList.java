import java.util.ArrayList;
import java.util.List;

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

    private boolean boolify(String b) {
        int i = Integer.parseInt(b);
        if (i == 0) return false;
        if (i == 1) return true;
        return false;
    }

    public void loadData(List<String> list) throws DataException{
        if (list.isEmpty()) throw new DataException("Data file empty");
        int elements = list.size();
        int i = 0;

        while (i < elements) {
            String[] str = list.get(i).split(",");
            switch (str[0]) {
            case "T":
                this.add(new Todo(str[2], boolify(str[1])));
                i++;
                continue;
            case "D":
                this.add(new Deadline(str[2], boolify(str[1]), str[3]));
                i++;
                continue;
            case "E":
                this.add(new Event(str[2], boolify(str[1]), str[3], str[4]));
                i++;
                continue;
            default:
                break;
            }
        }
    }
}
