package seedu.duke.flashutils.types;

import java.util.ArrayList;
import java.util.HashMap;

public class FlashCard {

    private final HashMap<String, FlashCardSet> flashCards;

    FlashCard(){
        this.flashCards = new HashMap<>();
    }

    FlashCard(HashMap<String, FlashCardSet> flashCards){
        this.flashCards = flashCards;
    }

    public FlashCardSet get(String key) {
        return flashCards.get(key);
    }
}
