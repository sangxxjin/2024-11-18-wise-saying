package org.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.example.model.WiseSaying;
import org.example.config.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WiseSayingServiceTest {

    private WiseSayingService wiseSayingService;
    private String filePath;

    @BeforeEach
    void setUp() {
        wiseSayingService = new WiseSayingService();
        filePath = AppConfig.testFilePath();
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

    @Test
    @DisplayName("파일에 명언 저장 테스트")
    void saveToFile() throws IOException {
        String saying = "명언";
        String author = "작가";
        int id = wiseSayingService.addWiseSaying(saying, author);
        wiseSayingService.saveToFile(id, saying, author, filePath);
        String savedFilePath = filePath + id + AppConfig.jsonFileType();
        File file = new File(savedFilePath);
        assertThat(file.exists()).isTrue();

        file.delete();
    }

    @Test
    @DisplayName("파일 삭제 테스트")
    void deleteWiseSayingFile() throws IOException {
        String saying = "명언";
        String author = "작가";
        int id = wiseSayingService.addWiseSaying(saying, author);
        wiseSayingService.saveToFile(id, saying, author, filePath);

        wiseSayingService.deleteWiseSayingFile(id, filePath);

        String savedFilePath = filePath + id + AppConfig.jsonFileType();
        File file = new File(savedFilePath);
        assertThat(file.exists()).isFalse();
    }

    @Test
    @DisplayName("모든 파일 삭제 테스트")
    void deleteAllFiles() throws IOException {
        wiseSayingService.addWiseSaying("명언1", "작가1");
        wiseSayingService.addWiseSaying("명언2", "작가2");
        wiseSayingService.saveToFile(1, "명언1", "작가1", filePath);
        wiseSayingService.saveToFile(2, "명언2", "작가2", filePath);

        wiseSayingService.deleteAllFiles(filePath);

        File directory = new File(filePath);
        File[] files = directory.listFiles();
        assertThat(files).isEmpty();
    }

}
