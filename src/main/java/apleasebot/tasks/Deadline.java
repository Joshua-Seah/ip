package apleasebot.tasks;

import apleasebot.ui.TimeFormatter;

import java.time.LocalDateTime;

public class Deadline extends Task {

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