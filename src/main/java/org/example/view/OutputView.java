package org.example.view;

public class OutputView {

    public static final String START_MESSAGE = "== 명언 앱 ==";
    public static final String INPUT_PROMPT = "명령) ";
    public static final String FINISH_REGISTER = "번 명언이 등록되었습니다.";


    public void showStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void showInputPrompt() {
        System.out.print(INPUT_PROMPT);
    }

    public void showFinishRegister(int number) {
        System.out.println(number + FINISH_REGISTER);
    }

}
