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

    public void markDone() {
        this.isDone = true;
    }
    public void markUndone() {
        this.isDone = false;
    }
    public int checkDone() {
        return this.isDone ? 1 : 0;
    };
    public abstract String translateTaskToText();
    public abstract String toString();
}
