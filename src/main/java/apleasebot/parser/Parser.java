package apleasebot.parser;

import apleasebot.commands.*;
import apleasebot.exceptions.APleaseBotException;
import apleasebot.exceptions.UnknownCommandException;
import apleasebot.ui.Storage;

public class Parser {
    public static Command parse(String input, Storage data) throws APleaseBotException {
        if (input.equals("bye")) return new ByeCommand(data);
        if (input.equals("help")) return new HelpCommand();
        if (input.equals("list")) return new ListCommand();
        if (input.startsWith("mark")) return new MarkCommand(input);
        if (input.startsWith("unmark")) return new UnmarkCommand(input);
        if (input.startsWith("todo")) return new ToDoCommand(input);
        if (input.startsWith("deadline")) return new DeadlineCommand(input);
        if (input.startsWith("event")) return new EventCommand(input);
        if (input.startsWith("delete")) return new DeleteCommand(input);
        throw new UnknownCommandException(input);
    }
}
