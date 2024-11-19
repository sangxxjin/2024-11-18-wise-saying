package org.example.controller;

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
        switch (command) {
            case "종료":
                commandService.exitSystem();
            case "등록":
                inputView.showSayingPrompt();
                String saying = inputView.getInput();
                inputView.showAuthorPrompt();
                String author = inputView.getInput();
                commandService.addWiseSaying(saying, author);
        }
    }
}