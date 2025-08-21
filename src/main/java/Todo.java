class Todo extends Task {
    public Todo(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "[T]" + (isDone ? "[X] " : "[ ] ") + name;
    }
}