package nustracker.logic.parser;

import static java.util.Objects.requireNonNull;
import static nustracker.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static nustracker.logic.parser.CliSyntax.PREFIX_EMAIL;
import static nustracker.logic.parser.CliSyntax.PREFIX_MAJOR;
import static nustracker.logic.parser.CliSyntax.PREFIX_NAME;
import static nustracker.logic.parser.CliSyntax.PREFIX_NUSNETID;
import static nustracker.logic.parser.CliSyntax.PREFIX_PHONE;
import static nustracker.logic.parser.CliSyntax.PREFIX_TAG;
import static nustracker.logic.parser.CliSyntax.PREFIX_YEAR;

import nustracker.logic.commands.EditCommand;
import nustracker.logic.parser.exceptions.ParseException;
import nustracker.model.student.NusNetId;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                        PREFIX_YEAR, PREFIX_NUSNETID, PREFIX_MAJOR, PREFIX_TAG);

        if (!argMultimap.arePrefixesPresent(PREFIX_NUSNETID) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
        }

        NusNetId nusNetIdToEdit = ParserUtil.parseNusNetId(argMultimap.getAllValues(PREFIX_NUSNETID).get(0));


        EditCommand.EditStudentDescriptor editStudentDescriptor = new EditCommand.EditStudentDescriptor();
        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            editStudentDescriptor.setName(ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
        }
        if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            editStudentDescriptor.setPhone(ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));
        }
        if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
            editStudentDescriptor.setEmail(ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
        }
        if (argMultimap.getValue(PREFIX_YEAR).isPresent()) {
            editStudentDescriptor.setYear(ParserUtil.parseYear(argMultimap.getValue(PREFIX_YEAR).get()));
        }
        if (argMultimap.getValue(PREFIX_MAJOR).isPresent()) {
            editStudentDescriptor.setMajor(ParserUtil.parseMajor(argMultimap.getValue(PREFIX_MAJOR).get()));
        }
        if (argMultimap.getValue(PREFIX_NUSNETID).isPresent()) {
            editStudentDescriptor.setNusNetId(ParserUtil.parseNusNetId(argMultimap.getValue(PREFIX_NUSNETID).get()));
        }

        if (!editStudentDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }

        return new EditCommand(nusNetIdToEdit, editStudentDescriptor);
    }

}
