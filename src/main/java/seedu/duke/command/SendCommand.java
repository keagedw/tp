package seedu.duke.command;

import seedu.duke.model.Blockchain;
import seedu.duke.model.WalletManager;

public class SendCommand extends Command {
    private static final String INVALID_FORMAT_ERROR = "Error: Invalid send format. Use: send w/WALLET to/ADDR amt/AMT";
    private static final String WALLET_NOT_FOUND_ERROR = "Error: Wallet not found.";
    private static final String AMOUNT_INVALID_ERROR = "Error: Amount must be a positive number.";
    private static final String INSUFFICIENT_BALANCE_ERROR = "Error: Insufficient balance.";
    private static final String INVALID_ADDRESS_ERROR = "Error: Invalid recipient address.";

    private final String arguments;
    private final WalletManager walletManager;

    public SendCommand(String arguments, WalletManager walletManager) {
        this.arguments = arguments;
        this.walletManager = walletManager;
    }

    @Override
    public void execute(Blockchain blockchain) {
        // Parse arguments
        ParsedArgs parsed = parseArguments(arguments);
        if (parsed == null) {
            System.out.println(INVALID_FORMAT_ERROR);
            return;
        }

        // Validate wallet exists
        if (!walletManager.hasWallet(parsed.walletName)) {
            System.out.println(WALLET_NOT_FOUND_ERROR);
            return;
        }

        // Validate amount
        double amount = parseAmount(parsed.amount);
        if (amount <= 0) {
            System.out.println(AMOUNT_INVALID_ERROR);
            return;
        }

        // Validate recipient address
        if (!isValidAddress(parsed.recipientAddress)) {
            System.out.println(INVALID_ADDRESS_ERROR);
            return;
        }

        // Calculate balance
        double balance = blockchain.getBalance(parsed.walletName);
        double fee = parsed.fee != null ? parseAmount(parsed.fee) : 0.0;
        if (balance < amount + fee) {
            System.out.println(INSUFFICIENT_BALANCE_ERROR);
            return;
        }

        // If all validations pass, print success (for now, since actual sending not implemented)
        System.out.println("Send command validated successfully.");
        System.out.println("Wallet: " + parsed.walletName);
        System.out.println("To: " + parsed.recipientAddress);
        System.out.println("Amount: " + amount);
        if (parsed.speed != null) {
            System.out.println("Speed: " + parsed.speed);
        }
        if (parsed.fee != null) {
            System.out.println("Fee: " + fee);
        }
        if (parsed.note != null) {
            System.out.println("Note: " + parsed.note);
        }
    }

    private ParsedArgs parseArguments(String args) {
        if (args == null || args.isBlank()) {
            return null;
        }

        String[] parts = args.split("\\s+");
        ParsedArgs parsed = new ParsedArgs();

        for (String part : parts) {
            if (part.startsWith("w/")) {
                parsed.walletName = part.substring(2);
            } else if (part.startsWith("to/")) {
                parsed.recipientAddress = part.substring(3);
            } else if (part.startsWith("amt/")) {
                parsed.amount = part.substring(4);
            } else if (part.startsWith("speed/")) {
                parsed.speed = part.substring(6);
            } else if (part.startsWith("fee/")) {
                parsed.fee = part.substring(4);
            } else if (part.startsWith("note/")) {
                parsed.note = part.substring(5);
            } else {
                return null; // Invalid prefix
            }
        }

        // Required fields
        if (parsed.walletName == null || parsed.recipientAddress == null || parsed.amount == null) {
            return null;
        }

        return parsed;
    }

    private double parseAmount(String amountStr) {
        try {
            return Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean isValidAddress(String address) {
        // For now, assume address is a wallet name, so check if it's not empty and has no spaces
        return address != null && !address.isBlank() && !address.contains(" ");
    }

    private static class ParsedArgs {
        String walletName;
        String recipientAddress;
        String amount;
        String speed;
        String fee;
        String note;
    }
}
