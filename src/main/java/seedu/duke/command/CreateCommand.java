package seedu.duke.command;

public class CreateCommand extends Command {
    private static final String HELP_DESCRIPTION = """
            format: create NAME
            Creates a wallet called NAME
            """;

    public CreateCommand() {
        super(HELP_DESCRIPTION);
    }

    @Override
    public void execute(String description) {
        System.out.println("create command executed");
    }
}
