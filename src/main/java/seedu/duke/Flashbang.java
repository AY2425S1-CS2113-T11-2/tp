package seedu.duke;

import seedu.duke.flashutils.commands.Command;
import seedu.duke.flashutils.commands.CommandResult;
import seedu.duke.flashutils.commands.QuitCommand;
import seedu.duke.flashutils.types.FlashBook;
import seedu.duke.flashutils.utils.Parser;
import seedu.duke.flashutils.utils.Storage;
import seedu.duke.flashutils.utils.Ui;

import java.io.IOException;

import static seedu.duke.flashutils.utils.Ui.displayCommands;

public class Flashbang {
    /**
     * Main entry-point for the java.duke.Flashbang application.
     */

    private Ui ui;
    private Storage storage;
    private FlashBook flashBook;

    private Flashbang(String dataPath) {
        ui = new Ui();
        storage = new Storage(dataPath);
        try {
            FlashBook.setInstance(storage.readFlashCardsFromFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        flashBook = FlashBook.getInstance();
    }

    private void run() {
        Ui.welcomeMessage(); 
        String input = "";
        Command command = null;
        while (!(command instanceof QuitCommand)) {
            try {
                input = Ui.getRequest();
                command = Parser.parseCommand(input);
                CommandResult result = command.execute();
                Ui.printResponse(result.feedbackToUser);
                storage.writeFlashBookToFile(FlashBook.getInstance());
            } catch (IllegalArgumentException e) {
                Ui.printResponse("Please enter a valid index");
                displayCommands();
            }
        }
    }

    /**
     * Main function to run the Flashbang app
     */
    public static void main(String[] args) {
        new Flashbang("./data").run();
    }
}
