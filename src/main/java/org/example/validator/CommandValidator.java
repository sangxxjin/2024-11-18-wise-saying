package org.example.validator;

import org.example.enums.Command;

public class CommandValidator {

    public static boolean isExistCommand(String command) {
        return Command.isContains(command);
    }

}
