package org.example.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner sc = new Scanner(System.in);
    public static String getInput(){
        return sc.nextLine();
    }
}
