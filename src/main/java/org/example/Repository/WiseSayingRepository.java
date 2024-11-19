package org.example.Repository;

import java.util.ArrayList;
import java.util.List;
import org.example.model.WiseSaying;

public class WiseSayingRepository {

    public List<WiseSaying> wiseSayings = new ArrayList<>();

    public int addWiseSaying(String saying, String author) {
        WiseSaying newWiseSaying = new WiseSaying(saying, author);
        wiseSayings.add(newWiseSaying);
        return newWiseSaying.getId();
    }
    public List<WiseSaying> getWiseSayings() {
        return wiseSayings;
    }
    public int deleteWiseSaying(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId() == id) {
                wiseSayings.remove(wiseSaying);
            }
        }
        return id;
    }
    public boolean findWiseSaying(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
