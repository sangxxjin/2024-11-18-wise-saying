package org.example.view;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);
    private static final String SAYING_PROMPT = "명언 : ";
    private static final String AUTHOR_PROMPT = "작가 : ";



    public String getInput() {
        return sc.nextLine();
    }
    public int extractDeleteWiseSayingId(String input) {
        return Integer.parseInt(input.split("id=")[1]);
    }

    public void showSayingPrompt() {
        System.out.print(SAYING_PROMPT);
    }

    public void showAuthorPrompt() {
        System.out.print(AUTHOR_PROMPT);
    }


}
