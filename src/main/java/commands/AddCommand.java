package commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCard;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;

import java.util.ArrayList;

/**
 * Adds a flashcard to flashcard set.
 */
public class AddCommand extends Command {
    private final String module;
    private final String question;
    private final String answer;

    public AddCommand(String module, String question, String answer) {
        this.module = module;
        this.question = question;
        this.answer = answer;
    }

    public static final String COMMAND_WORD = "add";

    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully added flashcard: %1$s";
    public void execute(FlashCard flashCards) {
        ArrayList<Card> moduleArray = flashCards.get(module).getFlashCardSet();
        moduleArray.add(new Card(question, answer));
    }
}
