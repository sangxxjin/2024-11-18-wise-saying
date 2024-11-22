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

    public void saveToFile(int id, String saying, String author, String filePath) throws IOException {
        wiseSayingRepository.saveToFile(id, saying, author, filePath);
    }

    public void deleteAllFiles(String filePath) {
        wiseSayingRepository.deleteAllFiles(filePath);
    }

    public void deleteWiseSayingFile(int id,String filePath) {
        wiseSayingRepository.deleteWiseSayingFile(id, filePath);

    }

    public void saveLastWiseSayingIdToFile(String filePath) throws IOException {
        wiseSayingRepository.saveLastWiseSayingIdToFile(filePath);
    }

    public void saveDataFile(List<WiseSaying> wiseSayings,String filePath) {
        wiseSayingRepository.saveDataFile(wiseSayings, filePath);
    }


}