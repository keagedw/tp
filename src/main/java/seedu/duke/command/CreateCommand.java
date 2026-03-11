package seedu.duke.command;

import seedu.duke.model.Blockchain;
import seedu.duke.model.Wallet;
import seedu.duke.model.WalletManager;

public class CreateCommand extends Command {
    private static final String NAME_ERROR = "Error: wallet name cannot be empty.";
    private static final String DUPLICATE_ERROR = "Error: wallet name already exists.";

    private final String walletName;
    private final WalletManager walletManager;

    public CreateCommand(String walletName, WalletManager walletManager) {
        this.walletName = walletName;
        this.walletManager = walletManager;
    }

    @Override
    public void execute(Blockchain blockchain) {
        if (walletName == null || walletName.isBlank()) {
            System.out.println(NAME_ERROR);
            return;
        }

        String trimmedWalletName = walletName.trim();
        if (walletManager.hasWallet(trimmedWalletName)) {
            System.out.println(DUPLICATE_ERROR);
            return;
        }

        Wallet wallet = walletManager.createWallet(trimmedWalletName);
        System.out.println("Wallet created: " + wallet.getName());
    }
}
