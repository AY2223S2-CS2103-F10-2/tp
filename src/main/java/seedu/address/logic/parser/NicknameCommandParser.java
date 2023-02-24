package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NICKNAME;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.NicknameCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Nickname;

public class NicknameCommandParser implements Parser<NicknameCommand> {

    @Override
    public NicknameCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NICKNAME);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, NicknameCommand.MESSAGE_USAGE),
                    ive);
        }

        Nickname nickname = new Nickname(argMultimap.getValue(PREFIX_NICKNAME).orElse(""));

        return new NicknameCommand(index, nickname);
    }
}
