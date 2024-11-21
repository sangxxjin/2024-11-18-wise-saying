package org.example.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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

    public int updateWiseSaying(int id, String saying, String author) {
        return wiseSayingRepository.updateWiseSaying(id, saying, author);
    }

    public Map<String, String> getWiseSaying(int id) {
        return wiseSayingRepository.getWiseSaying(id);
    }

    public boolean isExistWiseSaying(int id) {
        return wiseSayingRepository.isExistWiseSaying(id);
    }
    public void saveToFile(int id, String saying, String author) throws IOException {
        wiseSayingRepository.saveToFile(id, saying, author);
    }

    public void deleteAllFiles() {
        wiseSayingRepository.deleteAllFiles();
    }
    public void deleteWiseSayingFile(int id){
        wiseSayingRepository.deleteWiseSayingFile(id);

    }
    public void saveLastWiseSayingIdToFile() throws IOException {
        wiseSayingRepository.saveLastWiseSayingIdToFile();
    }
    public void saveDataFile(List<WiseSaying> wiseSayings) {
        wiseSayingRepository.saveDataFile(wiseSayings);
    }


}