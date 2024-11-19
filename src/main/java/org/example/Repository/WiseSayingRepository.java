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

}
