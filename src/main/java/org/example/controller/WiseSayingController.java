package org.example.controller;

import org.example.service.CommandService;
import org.example.view.InputView;
import org.example.view.OutputView;

public class WiseSayingController {
    public void run(){
        OutputView.showStartMessage();
        CommandService commandService = new CommandService();
        while (true) {
            OutputView.showInputPrompt();
            commandService.checkCommand(InputView.getInput());
        }
    }
}