class Event extends Task {
    private String from;
    private String to;
    public Event(String name, boolean todo, String from, String to) {
        super(name, todo);
        this.from = from;
        this.to = to;
    }
    @Override
    public String toString() {
        return "[E] " + (isDone ? "[X] " : "[ ] ") + name +
                " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String translate() {
        return "E," + this.done() + "," + this.name + "," + this.from + "," + this.to;
    }
}