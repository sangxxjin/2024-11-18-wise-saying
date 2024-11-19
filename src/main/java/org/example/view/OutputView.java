package org.example.view;

import java.util.List;
import org.example.model.WiseSaying;

public class OutputView {

    private static final String START_MESSAGE = "== 명언 앱 ==";
    private static final String INPUT_PROMPT = "명령) ";
    private static final String FINISH_REGISTER = "번 명언이 등록되었습니다.";
    private static final String FINISH_DELETE = "번 명언이 삭제되었습니다.";
    private static final String NOT_EXITST_DELETE = "번 명언은 존재하지 않습니다.";
    private static final String HEADER = "번호 / 작가 / 명언";
    private static final String SEPARATOR = "----------------------";
    private static final String ORIGIN_SAYING_PROMPT = "명언(기존) : ";
    private static final String ORIGIN_AUTHOR_PROMPT = "작가(기존) : ";


    public void showStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void showInputPrompt() {
        System.out.print(INPUT_PROMPT);
    }

    public void showFinishRegister(int number) {
        System.out.println(number + FINISH_REGISTER);
    }

    public void showFinishDelete(int number) {
        System.out.println(number + FINISH_DELETE);
    }

    public void showNotExistWiseSaying(int number) {
        System.out.println(number + NOT_EXITST_DELETE);
    }
    public void showOriginWiseSaying(String saying){
        System.out.println(ORIGIN_SAYING_PROMPT+saying);
    }
    public void showOriginWiseSayingAuthor(String author){
        System.out.println(ORIGIN_AUTHOR_PROMPT+author);
    }
    public void showList(List<WiseSaying> wiseSayings) {
        System.out.println(HEADER);
        System.out.println(SEPARATOR);
        System.out.println(wiseSayings.size());
        StringBuilder sb = new StringBuilder();
        for (WiseSaying saying : wiseSayings) {
            sb.append(saying.getId()).append(" / ").append(saying.getAuthor()).append(" / ")
                .append(saying.getWiseSaying()).append("\n");
        }
        System.out.println(sb);
    }

}
