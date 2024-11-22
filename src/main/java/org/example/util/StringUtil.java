package org.example.util;

public class StringUtil {
    public static String parseToJson(int id, String wiseSaying, String author) {
        return "{\n" +
            "  \"id\": " + id + ",\n" +
            "  \"content\": \"" + wiseSaying + "\",\n" +
            "  \"author\": \"" + author + "\"\n" +
            "}";
    }
}
