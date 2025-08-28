import java.time.LocalDate;
import java.time.LocalDateTime;

class Deadline extends Task {

    private LocalDateTime by;

    public Deadline(String name, boolean todo, LocalDateTime by) {
        super(name, todo);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D] " + (isDone ? "[X] " : "[ ] ") + name + " (by: " + TimeFormatter.getTime(this.by) + ")";
    }

    @Override
    public String translate() {
        return "D," + this.done() + "," + this.name + "," + this.by;
    }
}