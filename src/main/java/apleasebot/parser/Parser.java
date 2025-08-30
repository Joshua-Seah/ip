package apleasebot.parser;

import apleasebot.commands.ByeCommand;
import apleasebot.commands.Command;
import apleasebot.commands.DeadlineCommand;
import apleasebot.commands.DeleteCommand;
import apleasebot.commands.EventCommand;
import apleasebot.commands.HelpCommand;
import apleasebot.commands.ListCommand;
import apleasebot.commands.MarkCommand;
import apleasebot.commands.ToDoCommand;
import apleasebot.commands.UnmarkCommand;
import apleasebot.exceptions.APleaseBotException;
import apleasebot.exceptions.UnknownCommandException;
import apleasebot.ui.Storage;

/**
 * Class to encapsulate the logic for recognising user inputs and passing along the input to the appropriate
 * command objects
 */
public class Parser {
    /**
     * Function that recognises the command
     * Functions that accept no argument are more specific while functions that require arguments just need to
     * begin with the keyword
     * @param input User input
     * @param data Storage file
     * @return A command object to be executed in the main file
     * @throws APleaseBotException Generic exception that can be thrown related to the command creation and parsing
     */
    public static Command parse(String input, Storage data) throws APleaseBotException {
        switch (input) {
        case "bye" -> {
            return new ByeCommand(data);
        }
        case "help" -> {
            return new HelpCommand();
        }
        case "list" -> {
            return new ListCommand();
        }
        case "mark" -> {
            return new MarkCommand(input);
        }
        case "unmark" -> {
            return new UnmarkCommand(input);
        }
        case "todo" -> {
            return new ToDoCommand(input);
        }
        case "deadline" -> {
            return new DeadlineCommand(input);
        }
        case "event" -> {
            return new EventCommand(input);
        }
        case "delete" -> {
            return new DeleteCommand(input);
        }
        default -> {
            throw new UnknownCommandException(input);
        }
        }
    }
}
