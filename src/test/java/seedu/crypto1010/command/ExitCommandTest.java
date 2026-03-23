package seedu.crypto1010.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import seedu.crypto1010.exceptions.Exceptions;
import seedu.crypto1010.model.Blockchain;

import org.junit.jupiter.api.Test;

class ExitCommandTest {
    @Test
    void execute_noArguments_succeeds() {
        ExitCommand command = new ExitCommand();
        Blockchain blockchain = Blockchain.createDefault();

        assertDoesNotThrow(() -> command.execute("", blockchain));
    }

    @Test
    void execute_withArguments_throwsFormatError() {
        ExitCommand command = new ExitCommand();
        Blockchain blockchain = Blockchain.createDefault();

        Exceptions exception = assertThrows(Exceptions.class, () -> command.execute("now", blockchain));
        assertEquals("Error: Invalid exit format. Use: exit", exception.getMessage());
    }
}
