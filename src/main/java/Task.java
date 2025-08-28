abstract class Task {
    protected String name;
    protected boolean isDone;

    public Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    public void markDone() { this.isDone = true; }
    public void markUndone() { this.isDone = false; }
    public int done() { return this.isDone ? 1 : 0; };
    public abstract String translate();
    public abstract String toString();
}