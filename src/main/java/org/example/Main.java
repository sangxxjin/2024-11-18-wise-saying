package org.example;

import org.example.controller.WiseSayingController;
import org.example.service.CommandService;
import org.example.view.InputView;
import org.example.view.OutputView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CommandService commandService = new CommandService();
        WiseSayingController controller = new WiseSayingController(inputView, outputView,
            commandService);
        controller.run();
    }
}