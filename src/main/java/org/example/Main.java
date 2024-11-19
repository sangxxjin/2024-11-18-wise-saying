package org.example;

import org.example.controller.WiseSayingController;
import org.example.service.WiseSayingService;
import org.example.view.InputView;
import org.example.view.OutputView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        WiseSayingService wiseSayingService = new WiseSayingService();
        WiseSayingController controller = new WiseSayingController(inputView, outputView,
            wiseSayingService);
        controller.run();
    }
}