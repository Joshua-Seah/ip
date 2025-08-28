class Todo extends Task {
    public Todo(String name, boolean todo) {
        super(name, todo);
    }
    @Override
    public String toString() {
        return "[T] " + (isDone ? "[X] " : "[ ] ") + name;
    }

    @Override
    public String translate() {
        return "T," + this.done() + "," + this.name;
    }
}