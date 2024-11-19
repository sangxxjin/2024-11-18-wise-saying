package org.example.service;

import java.util.List;
import org.example.Repository.WiseSayingRepository;
import org.example.model.WiseSaying;

public class CommandService {
    private final WiseSayingRepository wiseSayingRepository;

    public CommandService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public void exitSystem() {
        System.exit(0);
    }

    public int addWiseSaying(String saying, String author) {
        return wiseSayingRepository.addWiseSaying(saying, author);
    }
    public List<WiseSaying> getWiseSayings() {
        return wiseSayingRepository.getWiseSayings();
    }
}