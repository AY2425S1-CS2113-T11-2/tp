package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;

/**
 * Adds a flashcard to flashcard set.
 */
public class AddCommand extends Command {
    
    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully added flashcard: \n%1$s";

    private Card cardToAdd;
    private FlashCardSet targetSet;

    /**
     * Constructs a new Add Command with specified module, question and answer 
     * This creates new card and add it to the desired module
     * 
     * @param module
     * @param question
     * @param answer
     */
    public AddCommand(FlashCardSet module, String question, String answer) {
        if (module == null || question == null || answer == null) {
            throw new NullPointerException();
        }

        cardToAdd = new Card(question, answer);
        this.targetSet = module;
    }

    /**
     * Constructs a new Add Command that add an existing card into the module
     * 
     * @param cardToAdd 
     * @param module 
     */
    public AddCommand(FlashCardSet module, Card cardToAdd) {
        this.cardToAdd = cardToAdd;
        this.targetSet = module;
    }

    /**
     * Gets the card to be added
     * 
     * @return The Card object to be added
     */
    public Card getCardToAdd() {
        return cardToAdd;
    }

    /**
     * Gets the module name of the card
     * 
     * @return The target module 
     */
    public FlashCardSet getTargetSet() {
        return targetSet;
    }

    /**
     * Prints result of the command, 
     * which includes the success message and the Card to be added
     * 
     * @return The result of the command
     */
    @Override
    public CommandResult execute() {
        targetSet.addCard(cardToAdd);
        return new CommandResult(String.format(SUCCESS_MESSAGE, cardToAdd));
    }
}
