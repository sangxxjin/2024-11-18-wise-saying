package org.example.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.example.model.WiseSaying;

public class WiseSayingRepository {

    public List<WiseSaying> wiseSayings = new ArrayList<>();

    public int addWiseSaying(String saying, String author) {
        WiseSaying newWiseSaying = new WiseSaying(saying, author);
        wiseSayings.add(newWiseSaying);
        return newWiseSaying.getId();
    }

    public Map<String, String> getWiseSaying(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return Map.of(
                    "wiseSaying", wiseSaying.getWiseSaying(),
                    "author", wiseSaying.getAuthor()
                );
            }
        }
        throw new NoSuchElementException("해당하는 명언을 찾을 수 없습니다.");
    }

    public List<WiseSaying> getWiseSayings() {
        return wiseSayings;
    }

    public int deleteWiseSaying(int id) {
        wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
        return id;
    }

    public int updateWiseSaying(int id, String saying, String author) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                wiseSaying.setSaying(saying);
                wiseSaying.setAuthor(author);
            }
        }
        return id;
    }

    public boolean isExistWiseSaying(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int getLastWiseSayingId() {
        int maxId = 0;
        for (WiseSaying wiseSaying : wiseSayings) {
            if (maxId < wiseSaying.getId()) {
                maxId = wiseSaying.getId();
            }
        }
        return maxId;
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

    public void deleteWiseSayingFile(int id) {
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
        int lastWiseSayingId = getLastWiseSayingId();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(String.valueOf(lastWiseSayingId));
        }
    }

    public void saveDataFile(List<WiseSaying> wiseSayings) {
        String filePath = "src/main/java/org/example/db/wiseSaying/data.json";
        try (FileWriter writer = new FileWriter(filePath)) {
            List<String> jsonList = new ArrayList<>();
            for (WiseSaying wiseSaying : wiseSayings) {
                String json = "{" +
                    "\"id\": " + wiseSaying.getId() + "," +
                    "\"content\": \"" + wiseSaying.getWiseSaying() + "\"," +
                    "\"author\": \"" + wiseSaying.getAuthor() + "\"" +
                    "}";
                jsonList.add(json);
            }
            writer.write("[");
            writer.write(String.join(",", jsonList));
            writer.write("]");
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

}
