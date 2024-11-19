package org.example.Repository;

import java.util.ArrayList;
import java.util.List;
import org.example.model.WiseSaying;

public class WiseSayingRepository {

    public List<WiseSaying> wiseSayings = new ArrayList<>();

    public void addWiseSaying(String saying, String author) {
        wiseSayings.add(new WiseSaying(saying, author));
    }
}
