package org.example.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    private FileUtil() {

    }

    public static void writeToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        boolean isDeleted = false;
        try {
            isDeleted = file.delete();
        } catch (Exception e) {
            System.err.println("Error deleting file: " + file.getName());
        }
        return isDeleted;
    }
    public static void deleteFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteFile(file.getPath());
            }
        }
    }
}
