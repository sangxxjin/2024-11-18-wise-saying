package org.example.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.example.model.WiseSaying;
import org.example.util.FileUitl;
import org.example.util.StringUtil;

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

    public void saveToFile(int id, String saying, String author, String baseFilePath)
        throws IOException {
        String json = StringUtil.parseToJson(id, saying, author);

        String filePath = baseFilePath + id + ".json";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        }
    }

    public void deleteAllFiles(String baseFilePath) {
        File directory = new File(baseFilePath);
        File[] files = directory.listFiles();
        for (File file : files) {
            try {
                file.delete();
            } catch (Exception e) {
                System.err.println("Error deleting file: " + file.getName());
            }
        }
    }

    public void deleteWiseSayingFile(int id, String baseFilePath) {
        String filePath = baseFilePath + id + ".json";
        File file = new File(filePath);
        try {
            file.delete();
        } catch (Exception e) {
            System.err.println("Error deleting file: " + file.getName());
        }

    }

    public void saveLastWiseSayingIdToFile(String baseFilePath) throws IOException {
        String filePath = baseFilePath + FileUitl.lastIdFileName();
        int lastWiseSayingId = getLastWiseSayingId();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(String.valueOf(lastWiseSayingId));
        }
    }

    public void saveDataFile(List<WiseSaying> wiseSayings, String baseFilePath) {
        String filePath = baseFilePath + FileUitl.dataFileName();
        try (FileWriter writer = new FileWriter(filePath)) {
            List<String> jsonList = new ArrayList<>();
            for (WiseSaying wiseSaying : wiseSayings) {
                String json = StringUtil.parseToJson(
                    wiseSaying.getId(),
                    wiseSaying.getWiseSaying(),
                    wiseSaying.getAuthor()
                );
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
