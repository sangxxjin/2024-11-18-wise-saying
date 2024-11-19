package org.example.enums;

public enum Command {
    EXIT("종료"),
    REGISTER("등록"),
    LIST("목록"),
    DELETE("삭제"),
    UPDATE("수정");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isContains(String command) {
        for (Command commandEnum : Command.values()) {
            if (command.contains(commandEnum.getValue())) {
                return true;
            }
        }
        return false;
    }
}
