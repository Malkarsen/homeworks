package de.homeworks.homework40;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task1BufferedReader {
    public static void main(String[] args) {
        String filePath = "src/main/java/de/homeworks/homework40/tasks.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
            exception.printStackTrace();
        } catch (IOException exception) {
            System.out.println("Error reading from file");
            exception.printStackTrace();
        }
    }
}
