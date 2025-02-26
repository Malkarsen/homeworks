package de.homeworks.homework42;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class Task1Reader {
    public static void main(String[] args) {
        Path path = Path.of("src/main/java/de/homeworks/homework42/travel_route.txt");
        try {
            List<String> allLines = Files.readAllLines(path);
            if (!allLines.isEmpty()) {
                System.out.println("Travel Route:");
                int count = 1;
                for (String line : allLines) {
                    System.out.println(count + ". " + line);
                    count++;
                }
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException exception) {
            System.out.println("Error reading the file: " + exception.getMessage());
            log.error("Error reading the file: {}", exception.getMessage());
        }
    }
}
