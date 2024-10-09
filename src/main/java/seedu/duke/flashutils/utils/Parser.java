package seedu.duke.flashutils.utils;

import commands.AddCommand;
import commands.Command;
import commands.InvalidCommand;

public class Parser {
    public static Command parseUserInput(String input) {
        String[] splitInput = input.split(" ");
        switch (splitInput[0].toLowerCase()) {
        case "add":
            return prepareAdd(input);
        default: return new InvalidCommand();
        }
    }
    private static Command prepareAdd(String input) {
            String module = input.substring(input.indexOf("--m") + 3, input.indexOf("--q") - 1);
            String question = input.substring(input.indexOf("--q") + 3, input.indexOf("--a") - 1);
            String answer = input.substring(input.indexOf("--a") + 3);
            return new AddCommand(module, question, answer);
    }
}
