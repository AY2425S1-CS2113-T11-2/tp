package commands;

import seedu.duke.flashutils.types.FlashCard;

public class InvalidCommand extends Command {
    public void execute(FlashCard flashCards) {
        throw new IllegalArgumentException("uh oh bad command");
    }
}
