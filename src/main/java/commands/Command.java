package commands;

import seedu.duke.flashutils.types.FlashCard;

/**
 * Represents an executable command.
 */
public abstract class Command {
    public abstract void execute(FlashCard flashCards);
}
