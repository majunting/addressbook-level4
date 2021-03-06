package seedu.address.logic.commands.exceptions;

/**
 * Represents an error which occurs during execution of a {@link Command}.
 */
public class CommandException extends Exception {

    private String exceptionHeader;

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String header, String body) {
        super(body);
        this.exceptionHeader = header;
    }

    public String getExceptionHeader() {
        return exceptionHeader;
    }
}
