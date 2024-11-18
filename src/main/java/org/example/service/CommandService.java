package org.example.service;

import org.example.enums.Command;

public class CommandService {

    public void checkCommand(String command) {
        if (Command.EXIT.getValue().equals(command)) {
            System.exit(0);
        }
    }
}