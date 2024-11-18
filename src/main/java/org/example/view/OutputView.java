package org.example.view;

public class OutputView {
    public static final String START_MESSAGE = "== 명언 앱 ==";
    public static final String INPUT_PROMPT = "명령) ";

    public static void showStartMessage(){
        System.out.println(START_MESSAGE);
    }
    public static void showInputPrompt(){
        System.out.print(INPUT_PROMPT);
    }

}
