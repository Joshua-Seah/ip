abstract class Task {
    protected String name;
    protected boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void markDone() { this.isDone = true; }
    public void markUndone() { this.isDone = false; }
    public abstract String toString();
}