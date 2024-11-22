package org.example.config;

public class AppConfig {
    public static String testFilePath(){
        return "src/test/resources/db/wiseSaying/";
    }
    public static String originFilePath(){
        return "src/main/resources/db/wiseSaying/";
    }
    public static String dataFileName(){
        return "data"+jsonFileType();
    }
    public static String lastIdFileName(){
        return "lastId"+txtFileType();
    }
    public static String jsonFileType(){
        return ".json";
    }
    public static String txtFileType(){
        return ".txt";
    }
    public static String parseToJson(int id, String wiseSaying, String author) {
        return "{\n" +
            "  \"id\": " + id + ",\n" +
            "  \"content\": \"" + wiseSaying + "\",\n" +
            "  \"author\": \"" + author + "\"\n" +
            "}";
    }
}
