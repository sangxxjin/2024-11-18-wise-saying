package org.example.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.example.model.WiseSaying;

public class WiseSayingRepository {

    public List<WiseSaying> wiseSayings = new ArrayList<>();

    public int addWiseSaying(String saying, String author) {
        WiseSaying newWiseSaying = new WiseSaying(saying, author);
        wiseSayings.add(newWiseSaying);
        return newWiseSaying.getId();
    }
    public Map<String, String> getWiseSaying(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId() == id) {
                return Map.of(
                    "wiseSaying", wiseSaying.getWiseSaying(),
                    "author", wiseSaying.getAuthor()
                );
            }
        }
        return null;
    }
    public List<WiseSaying> getWiseSayings() {
        return wiseSayings;
    }
    public int deleteWiseSaying(int id) {
        wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
        return id;
    }
    public int updateWiseSaying(int id, String saying, String author) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId() == id) {
                wiseSaying.setSaying(saying);
                wiseSaying.setAuthor(author);
            }
        }
        return id;
    }
    public boolean isExistWiseSaying(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
