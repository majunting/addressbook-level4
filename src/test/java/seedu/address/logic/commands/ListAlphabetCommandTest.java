package seedu.address.logic.commands;

import org.junit.Test;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.NameStartsWithAlphabetPredicate;
import seedu.address.model.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

public class ListAlphabetCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        NameStartsWithAlphabetPredicate firstPredicate =
                new NameStartsWithAlphabetPredicate("f");
        NameStartsWithAlphabetPredicate secondPredicate =
                new NameStartsWithAlphabetPredicate("s");

        ListAlphabetCommand ListFirstCommand = new ListAlphabetCommand(firstPredicate);
        ListAlphabetCommand ListSecondCommand = new ListAlphabetCommand(secondPredicate);

        assertTrue(ListFirstCommand.equals(ListFirstCommand));

        ListAlphabetCommand ListFirstCommandCopy = new ListAlphabetCommand(firstPredicate);
        assertTrue(ListFirstCommand.equals(ListFirstCommandCopy));

        assertFalse(ListFirstCommand.equals(1));
        assertFalse(ListFirstCommand.equals(null));
        assertFalse(ListFirstCommand.equals(ListSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        ListAlphabetCommand command = prepareCommand(" ");
        assertCommandSuccess(command, expectedMessage, Collections.emptyList());
    }

    private ListAlphabetCommand prepareCommand(String input) {
        ListAlphabetCommand command =
                new ListAlphabetCommand(new NameStartsWithAlphabetPredicate(input));
        command.setData(model, new CommandHistory(), new UndoRedoStack());
        return command;
    }

    private void assertCommandSuccess(ListAlphabetCommand command, String expectedMessage, List<ReadOnlyPerson> expectedList) {
        AddressBook expectedAddressBook = new AddressBook(model.getAddressBook());
        CommandResult commandResult = command.execute();

        assertEquals(expectedMessage, commandResult.feedbackToUser);
        assertEquals(expectedList, model.getFilteredPersonList());
        assertEquals(expectedAddressBook, model.getAddressBook());
    }
}
