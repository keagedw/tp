package seedu.duke.command;

public class ViewBlockCommand extends Command {
    private static final String HELP_DESCRIPTION = """
            format: viewblock INDEX
            Displays the full details of a block
            Details include: Block Index, Timestamp, Previous Hash, Current Hash and List of Transactions
            """;

    public ViewBlockCommand() {
        super(HELP_DESCRIPTION);
    }

    @Override
    public void execute(String description) {
        System.out.println("view block command executed");
    }
}
