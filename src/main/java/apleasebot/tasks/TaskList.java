package apleasebot.tasks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import apleasebot.exceptions.APleaseBotException;
import apleasebot.exceptions.DataException;

/**
 * Class that aggregates the different tasks and provide some methods to use
 */
public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Default Constructor for an empty TaskList object
     */
    public TaskList() {

    }

    /**
     * Constructor that will initialise the TaskList object with tasks stored in the storage file
     * @param list Formatted list that contains stored tasks in String form
     * @throws DataException Exception thrown if there is an issue
     */
    public TaskList(List<String> list) throws DataException {
        if (list.isEmpty()) {
            throw new DataException("Data file empty");
        }
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
                this.add(new Deadline(str[2], boolify(str[1]), LocalDateTime.parse(str[3])));
                i++;
                continue;
            case "E":
                this.add(new Event(str[2], boolify(str[1]), LocalDateTime.parse(str[3]), LocalDateTime.parse(str[4])));
                i++;
                continue;
            default:
                break;
            }
        }
    }

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

    /**
     * Method that formats every task stored to a String to be displayed to the user
     * @return Formatted list of tasks
     */
    public String list() {
        if (this.tasks.isEmpty()) {
            throw new APleaseBotException("No items in list!");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getItemCount(); i++) {
            sb.append(i + 1).append(". ").append(this.get(i)).append("\n");
        }
        return sb.toString();
    }

    private boolean boolify(String b) {
        int i = Integer.parseInt(b);
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        return false;
    }
}
