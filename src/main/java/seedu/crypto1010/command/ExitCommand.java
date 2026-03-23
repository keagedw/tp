package seedu.crypto1010.command;

import seedu.crypto1010.exceptions.Exceptions;
import seedu.crypto1010.model.Blockchain;

public class ExitCommand extends Command {
    private static final String HELP_DESCRIPTION = """
            Format: exit
            Exits the program
            """;
    private static final String INVALID_FORMAT_ERROR = "Error: Invalid exit format. Use: exit";

    public ExitCommand() {
        super(HELP_DESCRIPTION);
    }

    @Override
    public void execute(String description, Blockchain blockchain) throws Exceptions {
        if (description != null && !description.isBlank()) {
            throw new Exceptions(INVALID_FORMAT_ERROR);
        }
    }
}
