package apleasebot.tasks;

import java.time.LocalDateTime;

import apleasebot.ui.TimeFormatter;

/**
 * Encapsulates Deadline task logic
 */
public class Deadline extends Task {

    private final LocalDateTime completeBy;

    /**
     * Constructor for the deadline class
     * @param name Name of the task
     * @param todo Completion status of the task for storage and loading purposes
     * @param by Time the deadline task needs to be completed by
     */
    public Deadline(String name, boolean todo, LocalDateTime by) {
        super(name, todo);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D] " + (isDone ? "[X] " : "[ ] ") + name + " (by: " + TimeFormatter.getTime(this.by) + ")";
    }

    @Override
    public String translateTaskToText() {
        return "D," + this.done() + "," + this.name + "," + this.by;
    }
}
