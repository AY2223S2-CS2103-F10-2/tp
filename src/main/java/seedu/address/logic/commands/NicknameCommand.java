package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Nickname;
import seedu.address.model.person.Person;

public class NicknameCommand extends Command {

    public static final String COMMAND_WORD = "nickname";

    public static final String MESSAGE_USAGE =
            COMMAND_WORD + ": Adds a nickname for the person identified"
                    + "by the index number used in the last person listing. "
                    + "An existing nickname will overwritten by the input.\n"
                    + "Parameters: INDEX (must be a positive integer) " + "nn/ [NICKNAME]\n"
                    + "Example: " + COMMAND_WORD + " 1 " + "nn/ Maverick";

    public static final String MESSAGE_ADD_NICKNAME_SUCCESS = "Added nickname to Person: %1$s";
    public static final String MESSAGE_DELETE_NICKNAME_SUCCESS =
            "Removed nickname from Person: %1$s";

    private final Index index;
    private final Nickname nickname;

    /**
     * @param index of the person in the filtered person list to edit the remark
     * @param nickname of the person to be updated to
     */
    public NicknameCommand(Index index, Nickname nickname) {
        requireAllNonNull(index, nickname);

        this.index = index;
        this.nickname = nickname;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson =
                new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                        personToEdit.getAddress(), personToEdit.getTags(), nickname);

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    private String generateSuccessMessage(Person personToEdit) {
        String message = !nickname.value.isEmpty() ? MESSAGE_ADD_NICKNAME_SUCCESS
                : MESSAGE_DELETE_NICKNAME_SUCCESS;
        return String.format(message, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof NicknameCommand)) {
            return false;
        }

        NicknameCommand c = (NicknameCommand) other;
        return index.equals(c.index) && nickname.equals(c.nickname);
    }
}
