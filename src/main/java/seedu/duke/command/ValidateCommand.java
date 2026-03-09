package seedu.duke.command;

import seedu.duke.model.Blockchain;

public class ValidateCommand extends Command {
    @Override
    public void execute(Blockchain blockchain) {
        System.out.println("validate command executed");
    }
}
