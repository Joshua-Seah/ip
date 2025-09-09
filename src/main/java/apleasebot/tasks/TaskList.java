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
    private final ArrayList<Task> tasks = new ArrayList<>();

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
        int numOfElements = list.size();
        int i = 0;

        while (i < numOfElements) {
            String[] str = list.get(i).split(",");
            switch (str[0]) {
            case "T":
                this.addTask(new Todo(str[2], boolify(str[1])));
                i++;
                continue;
            case "D":
                this.addTask(new Deadline(str[2], boolify(str[1]), LocalDateTime.parse(str[3])));
                i++;
                continue;
            case "E":
                this.addTask(new Event(str[2], boolify(str[1]), LocalDateTime.parse(str[3]), LocalDateTime.parse(str[4])));
                i++;
                continue;
            default:
                break;
            }
        }
    }

    /**
     * Function that adds a task to the tasklist
     * @param task Task object to be added
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Function that removes a task from the tasklist
     * @param index Index of Task to be removed
     */
    public void removeTask(int index) {
        assert index >= 0 && index < tasks.size();
        this.tasks.remove(index);
    }

    /**
     * Function that retrieves a task from the tasklist
     * @param index Index of Task to be retrieved
     * @return returns a Task
     */
    public Task getTask(int index) {
        assert index >= 0 && index < tasks.size();
        return this.tasks.get(index);
    }

    /**
     * Function that gets the size of the tasklist
     * @return Integer size of the tasklist
     */
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
            sb.append(i + 1).append(". ").append(this.getTask(i)).append("\n");
        }
        return sb.toString();
    }

    /**
     * Function to convert parsed boolean values in txt file to actual boolean values to be used in Task objects
     * @param b Parsed boolean value from txt file
     * @return Boolean to be used in Task objects
     */
    private boolean boolify(String b) {
        int i = Integer.parseInt(b);
        if (i == 0) {
            return false;
        }
        return i == 1;
    }

    /**
     * Method that filters and returns a new TaskList containing tasks that contained the keyphrase searched
     * @param keyphrase Keyword or phrase searched by user
     * @return Filtered TaskList
     */
    public TaskList search(String keyphrase) {
        TaskList copiedList = new TaskList();
        TaskList returnList;
        for (int i = 0; i < this.getItemCount(); i++) {
            copiedList.addTask(this.getTask(i));
        }
        returnList = new TaskList(
                copiedList.tasks.stream()
                        .filter(task -> task.desc.contains(keyphrase))
                        .map(Task::translateTaskToText)
                        .toList()
        );
        return returnList;
    }
}
