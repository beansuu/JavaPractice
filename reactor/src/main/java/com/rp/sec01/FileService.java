package com.rp.sec01;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileService {

    private static final String BASE_PATH = "src/main/java/com/rp/sec01/";

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> {
            try {
                return readFile(fileName);
            } catch (IOException e) {
                throw new RuntimeException("Error reading file", e);
            }
        });
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> {
            try {
                createFile(fileName, content);
            } catch (IOException e) {
                throw new RuntimeException("Error writing to file", e);
            }
        });
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> {
            try {
                deleteFile(fileName);
            } catch (IOException e) {
                throw new RuntimeException("Error deleting file", e);
            }
        });
    }

    private static String readFile(String filename) throws IOException {
        Path path = Paths.get(BASE_PATH + filename);
        return new String(Files.readAllBytes(path));
    }

    private static void createFile(String fileName, String content) throws IOException {
        Path path = Paths.get(BASE_PATH + fileName);
        Files.writeString(path, content, StandardOpenOption.CREATE);
    }

    private static void deleteFile(String filename) throws IOException {
        Path path = Paths.get(BASE_PATH + filename);
        Files.deleteIfExists(path);
    }
}
