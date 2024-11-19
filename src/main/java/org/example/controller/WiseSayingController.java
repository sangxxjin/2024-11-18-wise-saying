package org.example.controller;

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
            wiseSayingService.exitSystem();
        }
        if(Command.valueOf("REGISTER").getValue().equals(command)) {
            inputView.showSayingPrompt();
            String saying = inputView.getInput();
            inputView.showAuthorPrompt();
            String author = inputView.getInput();
            outputView.showFinishRegister(wiseSayingService.addWiseSaying(saying, author));
        }
        if(Command.valueOf("LIST").getValue().equals(command)) {
            outputView.showList(wiseSayingService.getWiseSayings());
        }
        //startsWith를 사용했는데 "삭제"라는 문구만 if문 안으로 진입하고
        //"삭제~"와 같이 삭제 뒤에 무언가를 붙이면 if문 안으로 들어가지를 못하고있습니다.
        //잠시분석좀할게요
        if (command.startsWith(Command.valueOf("DELETE").getValue())) {
            outputView.showFinishDelete(wiseSayingService.deleteWiseSaying(
                inputView.extractDeleteWiseSayingId(command)));
        }
    }
}