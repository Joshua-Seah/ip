class Parser {
    public static Command parse(String input) throws APleaseBotException {
        if (input.equals("help")) return new HelpCommand();
        if (input.equals("list")) return new ListCommand();
        if (input.startsWith("mark")) return new MarkCommand(input);
        if (input.startsWith("unmark")) return new UnmarkCommand(input);
        if (input.startsWith("todo")) return new ToDoCommand(input);
        if (input.startsWith("deadline")) return new DeadlineCommand(input);
        if (input.startsWith("event")) return new EventCommand(input);
        throw new UnknownCommandException(input);
    }
}
