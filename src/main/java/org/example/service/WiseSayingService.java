package org.example.service;

import java.util.List;
import org.example.Repository.WiseSayingRepository;
import org.example.model.WiseSaying;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
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
    public int deleteWiseSaying(int id) {
        return wiseSayingRepository.deleteWiseSaying(id);
    }
}