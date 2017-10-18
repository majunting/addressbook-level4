/** @@author: Junting **/
package seedu.address.logic.commands;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;
import seedu.address.model.tag.Tag;

/**
 * deletes a tag from all persons in addressbook.
 */
public class DeleteTagCommand extends Command{

    public static final String COMMAND_WORD = "deleteTag";
    public static final String COMMAND_ALIAS = "dt";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes a specific tag from all persons in addressbook.\n"
            + "Parameters: KEYWORD\n"
            + "Example: " + COMMAND_WORD + " friends";

    private static final String MESSAGE_DELETE_TAG_SUCCESS = "Tag deleted.";
    private final String keyword;

    public DeleteTagCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public CommandResult execute() throws CommandException{
        try {
            model.deleteTag(new Tag(keyword));
            return new CommandResult(MESSAGE_DELETE_TAG_SUCCESS);
        } catch (IllegalValueException ive) {
            throw new CommandException("Illegal value exception");
        } catch (PersonNotFoundException pnfe) {
            throw new CommandException("Person not found exception");
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this //short circuit if same object
                || (other instanceof DeleteTagCommand // instanceof handles nulls
                && this.keyword.equals(((DeleteTagCommand) other).keyword)); // state check
    }
}
