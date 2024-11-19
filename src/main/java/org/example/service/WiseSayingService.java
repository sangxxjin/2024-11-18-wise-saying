package org.example.service;

import java.io.File;
import java.io.FileWriter;
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
        String json = "{\n" +
            "  \"id\": " + id + ",\n" +
            "  \"content\": \"" + saying + "\",\n" +
            "  \"author\": \"" + author + "\"\n" +
            "}";

        String filePath = "src/main/java/org/example/db/wiseSaying/" + id + ".json";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        }
    }

    public void deleteAllFiles() {
        File directory = new File("src/main/java/org/example/db/wiseSaying");
        File[] files = directory.listFiles();
        for (File file : files) {
            try {
                file.delete();
            } catch (Exception e) {
                System.err.println("Error deleting file: " + file.getName());
            }
        }
    }
    public void deleteWiseSayingFile(int id){
        String filePath = "src/main/java/org/example/db/wiseSaying/" + id + ".json";
        File file = new File(filePath);
        try {
            file.delete();
        } catch (Exception e) {
            System.err.println("Error deleting file: " + file.getName());
        }

    }
    public void saveLastWiseSayingIdToFile() throws IOException {
        String filePath = "src/main/java/org/example/db/wiseSaying/lastId.txt";
        int lastWiseSayingId = wiseSayingRepository.getLastWiseSayingId();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(String.valueOf(lastWiseSayingId));
        }
    }
}