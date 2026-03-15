package seedu.duke.command;

public class KeygenCommand extends Command {
    private static final String HELP_DESCRIPTION = """
            format: keygen w/NAME
            Generates and displays key pair for new wallet, or regenerates for existing wallet
            Displays the process of creating a key pair
            """;

    public KeygenCommand() {
        super(HELP_DESCRIPTION);
    }

    @Override
    public void execute(String description) {
        System.out.println("keygen command executed");
    }
}
