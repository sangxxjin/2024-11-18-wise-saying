package org.example.enums;

public enum Command {
    EXIT("종료");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
