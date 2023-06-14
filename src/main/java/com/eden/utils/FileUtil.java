package com.eden.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtil {
    private FileUtil() {
    }

    public static void writeFile(String filePath, String contents) throws IOException {
        Files.write(Paths.get(filePath), contents.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
