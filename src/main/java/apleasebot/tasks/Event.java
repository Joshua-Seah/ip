package apleasebot.tasks;

import java.time.LocalDateTime;

import apleasebot.ui.TimeFormatter;

/**
 * Encapsulates the event logic
 */
public class Event extends Task {
    private final LocalDateTime from;
    private final LocalDateTime to;

    /**
     * Constructor for the event class
     * @param name Name of event
     * @param todo Completion status of the task for storage and loading purposes
     * @param from Event start time
     * @param to Event end time
     */
    public Event(String name, boolean todo, LocalDateTime from, LocalDateTime to) {
        super(name, todo);
        this.from = from;
        this.to = to;
    }
    @Override
    public String toString() {
        return "[E] " + (isDone ? "[X] " : "[ ] ") + name
                + " (from: " + TimeFormatter.getTime(this.from) + " to: " + TimeFormatter.getTime(this.to) + ")";
    }

    @Override
    public String translate() {
        return "E," + this.done() + "," + this.name + "," + this.from + "," + this.to;
    }
}
