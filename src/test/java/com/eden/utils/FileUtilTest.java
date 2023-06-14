package com.eden.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class FileUtilTest {

  private static final String PATH_TEST_DIR = "temp";
  private static final String PATH_TEST_FILE = PATH_TEST_DIR + "/history.txt";

  @Test
  void name() throws IOException {
    Files.createDirectory(Path.of(PATH_TEST_DIR));
  }

  @Test
  void createFileAsFileOutputStream() throws IOException {
    Path filePath = Paths.get(PATH_TEST_FILE);
    Files.deleteIfExists(filePath);
    File file = new File(PATH_TEST_FILE);

    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
    Assertions.assertThat(Files.exists(filePath)).isTrue();
  }

  @Test
  void createFileAsFiles() throws IOException {
    Path filePath = Paths.get(PATH_TEST_FILE);
    Files.deleteIfExists(filePath);

    Path newFilePath = Files.createFile(filePath);
    System.out.println(newFilePath);
    Assertions.assertThat(Files.exists(filePath)).isTrue();
  }

  @Test
  void writeFile() throws IOException {
    Path filePath = Paths.get(PATH_TEST_FILE);
    String message = String.format("\n안녕하세요. %s", DateUtil.getNow());
    Files.write(filePath, message.getBytes());
    Assertions.assertThat(Files.exists(filePath)).isTrue();
  }

  @Test
  void readFile() throws IOException {
    Path filePath = Paths.get(PATH_TEST_FILE);
    List<String> lines = Files.readAllLines(filePath);
    System.out.println(lines);
    Assertions.assertThat(Files.exists(filePath)).isTrue();
  }
}
