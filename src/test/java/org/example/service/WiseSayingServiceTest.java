package org.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.example.model.WiseSaying;
import org.example.util.FileUitl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WiseSayingServiceTest {

    private WiseSayingService wiseSayingService;
    private String filePath;

    @BeforeEach
    void setUp() {
        wiseSayingService = new WiseSayingService();
        filePath = FileUitl.testFilePath();
    }

    @Test
    @DisplayName("명언 생성 테스트")
    void addWiseSaying() {
        String saying = "명언";
        String author = "작가";
        int id = wiseSayingService.addWiseSaying(saying, author);
        List<WiseSaying> wiseSayings = wiseSayingService.getWiseSayings();
        assertThat(wiseSayings).hasSize(1);
        assertThat(wiseSayings.get(0).getId()).isEqualTo(id);
        assertThat(wiseSayings.get(0).getWiseSaying()).isEqualTo(saying);
        assertThat(wiseSayings.get(0).getAuthor()).isEqualTo(author);
    }

    @Test
    @DisplayName("명언 삭제 테스트")
    void deleteWiseSaying() {
        int id = wiseSayingService.addWiseSaying("명언", "작가");
        int deletedId = wiseSayingService.deleteWiseSaying(id);
        assertThat(deletedId).isEqualTo(id);
        assertThat(wiseSayingService.getWiseSayings()).isEmpty();
    }

    @Test
    void updateWiseSaying() {
        int id = wiseSayingService.addWiseSaying("명언", "작가");
        String newSaying = "새 명언";
        String newAuthor = "새 작가";
        int updatedId = wiseSayingService.updateWiseSaying(id, newSaying, newAuthor);
        assertThat(updatedId).isEqualTo(id);
        WiseSaying updated = wiseSayingService.getWiseSayings().get(0);
        assertThat(updated.getWiseSaying()).isEqualTo(newSaying);
        assertThat(updated.getAuthor()).isEqualTo(newAuthor);
    }

    @Test
    void isExistWiseSaying() {
        int id = wiseSayingService.addWiseSaying("명언", "작가");
        assertTrue(wiseSayingService.isExistWiseSaying(id));
        assertFalse(wiseSayingService.isExistWiseSaying(999));
    }
}
