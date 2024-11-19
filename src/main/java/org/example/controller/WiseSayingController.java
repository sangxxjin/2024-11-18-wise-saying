package org.example.controller;

import java.io.IOException;
import java.util.Map;
import org.example.enums.Command;
import org.example.service.WiseSayingService;
import org.example.validator.CommandValidator;
import org.example.view.InputView;
import org.example.view.OutputView;

public class WiseSayingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(InputView inputView, OutputView outputView,
        WiseSayingService wiseSayingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.wiseSayingService = wiseSayingService;
    }

    public void run() {
        wiseSayingService.deleteAllFiles();
        outputView.showStartMessage();
        try {
            while (true) {
                outputView.showInputPrompt();
                String command = inputView.getInput();
                if (!CommandValidator.isExistCommand(command)) {
                    continue;
                }
                runCommand(command);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void runCommand(String command) throws IOException {
        try {
            if (Command.valueOf("EXIT").getValue().equals(command)) {
                wiseSayingService.exitSystem();

            }
            if (Command.valueOf("REGISTER").getValue().equals(command)) {
                inputView.showSayingPrompt();
                String saying = inputView.getInput();
                inputView.showAuthorPrompt();
                String author = inputView.getInput();
                int wiseSayingId = wiseSayingService.addWiseSaying(saying, author);
                outputView.showFinishRegister(wiseSayingId);
                wiseSayingService.saveToFile(wiseSayingId, saying, author);
            }
            if (Command.valueOf("LIST").getValue().equals(command)) {
                outputView.showList(wiseSayingService.getWiseSayings());
            }
            if (command.startsWith(Command.valueOf("DELETE").getValue())) {
                int wiseSayingId = inputView.extractDeleteWiseSayingId(command);
                if (wiseSayingService.isExistWiseSaying(wiseSayingId)) {
                    outputView.showFinishDelete(wiseSayingService.deleteWiseSaying(wiseSayingId));
                } else {
                    outputView.showNotExistWiseSaying(wiseSayingId);
                }
            }
            if (command.startsWith(Command.valueOf("UPDATE").getValue())) {
                int wiseSayingId = inputView.extractDeleteWiseSayingId(command);
                if (wiseSayingService.isExistWiseSaying(wiseSayingId)) {
                    Map<String, String> wiseSaying = wiseSayingService.getWiseSaying(wiseSayingId);
                    outputView.showOriginWiseSaying(wiseSaying.get("wiseSaying"));
                    inputView.showSayingPrompt();
                    String newWiseSaying = inputView.getInput();
                    outputView.showOriginWiseSayingAuthor(wiseSaying.get("author"));
                    inputView.showAuthorPrompt();
                    String newAuthor = inputView.getInput();
                    wiseSayingService.updateWiseSaying(wiseSayingId, newWiseSaying, newAuthor);
                    wiseSayingService.saveToFile(wiseSayingId, newWiseSaying, newAuthor);
                } else {
                    outputView.showNotExistWiseSaying(wiseSayingId);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}