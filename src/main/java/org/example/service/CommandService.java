package org.example.service;

import org.example.Repository.WiseSayingRepository;

public class CommandService {

    public void exitSystem() {
        System.exit(0);
    }

    public void addWiseSaying(String saying, String author) {
        WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
        wiseSayingRepository.addWiseSaying(saying, author);
    }
}