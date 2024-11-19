package org.example.controller;

import org.example.enums.Command;
import org.example.service.CommandService;
import org.example.validator.CommandValidator;
import org.example.view.InputView;
import org.example.view.OutputView;

public class WiseSayingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CommandService commandService;

    public WiseSayingController(InputView inputView, OutputView outputView,
        CommandService commandService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.commandService = commandService;
    }

    public void run() {
        outputView.showStartMessage();
        while (true) {
            outputView.showInputPrompt();
            String command = inputView.getInput();
            if (!CommandValidator.isExistCommand(command)) {
                continue;
            }
            runCommand(command);
        }
    }

    private void runCommand(String command) {

        if(Command.valueOf("EXIT").getValue().equals(command)) {
            commandService.exitSystem();
        }
        if(Command.valueOf("REGISTER").getValue().equals(command)) {
            inputView.showSayingPrompt();
            String saying = inputView.getInput();
            inputView.showAuthorPrompt();
            String author = inputView.getInput();
            outputView.showFinishRegister(commandService.addWiseSaying(saying, author));
        }
        if(Command.valueOf("LIST").getValue().equals(command)) {
            outputView.showList(commandService.getWiseSayings());
        }
    }
}