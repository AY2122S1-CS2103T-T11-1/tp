package nustracker.logic.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nustracker.commons.core.Messages;
import nustracker.logic.commands.AddCommand;
import nustracker.logic.commands.BlackListCommand;
import nustracker.logic.commands.ClearCommand;
import nustracker.logic.commands.Command;
import nustracker.logic.commands.CreateCommand;
import nustracker.logic.commands.DeleteCommand;
import nustracker.logic.commands.EditCommand;
import nustracker.logic.commands.EnrollCommand;
import nustracker.logic.commands.EventsCommand;
import nustracker.logic.commands.ExitCommand;
import nustracker.logic.commands.ExportCommand;
import nustracker.logic.commands.FilterCommand;
import nustracker.logic.commands.HelpCommand;
import nustracker.logic.commands.RemoveCommand;
import nustracker.logic.commands.SettingsCommand;
import nustracker.logic.commands.StudentsCommand;
import nustracker.logic.commands.WhiteListCommand;
import nustracker.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FilterCommand.COMMAND_WORD:
            return new FilterCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case SettingsCommand.COMMAND_WORD:
            return new SettingsCommand();

        case CreateCommand.COMMAND_WORD:
            return new CreateCommandParser().parse(arguments);

        case EnrollCommand.COMMAND_WORD:
            return new EnrollCommandParser().parse(arguments);

        case RemoveCommand.COMMAND_WORD:
            return new RemoveCommandParser().parse(arguments);

        case BlackListCommand.COMMAND_WORD:
            return new BlackListCommandParser().parse(arguments);

        case WhiteListCommand.COMMAND_WORD:
            return new WhiteListCommandParser().parse(arguments);

        case ExportCommand.COMMAND_WORD:
            return new ExportCommandParser().parse(arguments);

        case EventsCommand.COMMAND_WORD:
            return new EventsCommand();

        case StudentsCommand.COMMAND_WORD:
            return new StudentsCommand();

        default:
            throw new ParseException(Messages.MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
