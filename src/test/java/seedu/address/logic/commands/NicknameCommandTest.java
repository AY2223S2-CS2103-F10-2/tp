package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Nickname;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class NicknameCommandTest {

    private static final String NICKNAME_STUB = "nick";
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_addNicknameUnfilteredList_success() {
        Person firstPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person editedPerson = new PersonBuilder(firstPerson).withNickname(NICKNAME_STUB).build();

        NicknameCommand nicknameCommand = new NicknameCommand(INDEX_FIRST_PERSON, new Nickname(editedPerson.getNickname().value));

        String expectedMessage = String.format(NicknameCommand.MESSAGE_ADD_NICKNAME_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstPerson, editedPerson);

        assertCommandSuccess(nicknameCommand, model, expectedMessage, expectedModel);
    }
}
