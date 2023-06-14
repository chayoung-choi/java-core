package com.eden.utils;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileUtilTest {

    private static final String PATH_TEST_DIR = "temp";
    private static final String PATH_TEST_FILE = PATH_TEST_DIR + "/history.txt";

    Path filePath = Paths.get(PATH_TEST_FILE);

    @Test
    void createDirectories() throws IOException {
        Path dirPath = Path.of(PATH_TEST_DIR);
        Files.createDirectories(dirPath);
        assertThat(Files.exists(dirPath)).isTrue();
    }

    @Test
    void createFileAsFileOutputStream() throws IOException {
        Files.deleteIfExists(filePath);
        File file = new File(PATH_TEST_FILE);

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            assertThat(Files.exists(filePath)).isTrue();
            assertThat(fos.toString()).isNotEmpty();
        }
    }

    @Test
    void createFileAsFiles() throws IOException {
        Files.deleteIfExists(filePath);

        Path newFilePath = Files.createFile(filePath);
        System.out.println(newFilePath);
        assertThat(Files.exists(filePath)).isTrue();
    }

    @Test
    void writeFile() throws IOException {
        String message = String.format("\n안녕하세요. %s", DateUtil.getNow());
        Files.write(filePath, message.getBytes());
        assertThat(Files.exists(filePath)).isTrue();
    }

    @Test
    void readFile() throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        System.out.println(lines);
        assertThat(Files.exists(filePath)).isTrue();
    }

    @RepeatedTest(5)
    void appendFile() throws IOException {
        String message = String.format("\n안녕하세요. %s", DateUtil.getNow());
        FileUtil.writeFile(filePath.toString(), message);
    }
}
