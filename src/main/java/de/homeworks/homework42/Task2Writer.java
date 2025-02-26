package de.homeworks.homework42;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

@Slf4j
public class Task2Writer {
    public static void main(String[] args) {
        Path path = Path.of("src/main/java/de/homeworks/homework42/travel_review.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your travel review: ");
        String userReview = scanner.nextLine().trim();

        try {
            Files.writeString(path, userReview + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Your review has been saved! ");
        } catch (IOException exception) {
            System.out.println("Error writing to a file: " + exception.getMessage());
            log.error("Error writing to a file: {}", exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
