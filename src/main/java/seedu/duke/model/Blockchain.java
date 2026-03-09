package seedu.duke.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private static final String GENESIS_PREVIOUS_HASH = "0000000000000000";

    private final List<Block> blocks;

    public Blockchain(List<Block> blocks) {
        this.blocks = new ArrayList<>(blocks);
    }

    public static Blockchain createDefault() {
        List<Block> defaultBlocks = new ArrayList<>();
        Block genesis = new Block(
                0,
                LocalDateTime.of(2026, 2, 12, 14, 30, 21),
                GENESIS_PREVIOUS_HASH,
                List.of("Genesis Block"));
        defaultBlocks.add(genesis);
        defaultBlocks.add(new Block(
                1,
                LocalDateTime.of(2026, 2, 12, 14, 35, 2),
                genesis.getCurrentHash(),
                List.of("alice -> bob : 10", "bob -> carol : 5")));
        return new Blockchain(defaultBlocks);
    }

    public int size() {
        return blocks.size();
    }

    public Block getBlock(int index) {
        return blocks.get(index);
    }
}
