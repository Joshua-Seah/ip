class Deadline extends Task {
    private String by;
    public Deadline(String name, boolean todo, String by) {
        super(name, todo);
        this.by = by;
    }
    @Override
    public String toString() {
        return "[D] " + (isDone ? "[X] " : "[ ] ") + name + " (by: " + by + ")";
    }

    @Override
    public String translate() {
        return "D," + this.done() + "," + this.name + "," + this.by;
    }
}