package apleasebot.tasks;

import apleasebot.ui.TimeFormatter;

import java.time.LocalDateTime;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;
    public Event(String name, boolean todo, LocalDateTime from, LocalDateTime to) {
        super(name, todo);
        this.from = from;
        this.to = to;
    }
    @Override
    public String toString() {
        return "[E] " + (isDone ? "[X] " : "[ ] ") + name +
                " (from: " + TimeFormatter.getTime(this.from) + " to: " + TimeFormatter.getTime(this.to) + ")";
    }

    @Override
    public String translate() {
        return "E," + this.done() + "," + this.name + "," + this.from + "," + this.to;
    }
}