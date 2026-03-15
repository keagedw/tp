package seedu.duke.command;

public class SendCommand extends Command {
    private static final String HELP_DESCRIPTION = """
            Format: send w/WALLET_NAME to/RECIPIENT_ADDRESS amt/AMOUNT [speed/SPEED] [fee/FEE] [note/MEMO]
            SPEED FEE and MEMO are optional arguments
            Sends cryptocurrency from one wallet to another address
            """;

    public SendCommand() {
        super(HELP_DESCRIPTION);
    }

    @Override
    public void execute(String description) {
        System.out.println("send command executed");
    }
}
