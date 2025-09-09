package apleasebot.tasks;

/**
 * Abstract class to declare what methods Tasks should implement
 * Also provides some methods for the children classes to inherit
 */
public abstract class Task {
    protected String desc;
    protected boolean isDone;

    /**
     * Constructor for basic Task object
     * @param name Name of task
     * @param isDone Completion status of the task for storage and loading purposes
     */
    public Task(String name, boolean isDone) {
        this.desc = name;
        this.isDone = isDone;
    }

    /**
     * Method to change isDone to true
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Method to change isDone to false
     */
    public void markUndone() {
        this.isDone = false;
    }

    /**
     * Method to return parsed boolean for storage
     * @return 0 for false, 1 for true
     */
    public int checkDone() {
        return this.isDone ? 1 : 0;
    };

    /**
     * Method to parse task to text for storage
     * @return Parsed task
     */
    public abstract String translateTaskToText();

    /**
     * Method to parse task for display to user
     * @return String message to user
     */
    public abstract String toString();
}
