package org.example;

import org.example.controller.WiseSayingController;
import org.example.service.WiseSayingService;
import org.example.util.FileUitl;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        WiseSayingService wiseSayingService = new WiseSayingService();
        WiseSayingController controller = new WiseSayingController(inputView, outputView,
            wiseSayingService, FileUitl.originFilePath());
        controller.run();
    }
}