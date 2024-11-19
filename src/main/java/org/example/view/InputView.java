package org.example.view;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);
    public static final String SAYING_PROMPT = "명언 : ";
    public static final String AUTHOR_PROMPT = "작가 : ";

    public String getInput() {
        return sc.nextLine();
    }

    public void showSayingPrompt() {
        System.out.print(SAYING_PROMPT);
    }

    public void showAuthorPrompt() {
        System.out.print(AUTHOR_PROMPT);
    }
}
