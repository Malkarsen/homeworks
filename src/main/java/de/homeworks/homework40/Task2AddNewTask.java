package de.homeworks.homework40;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task2AddNewTask {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String filePath = "src/main/java/de/homeworks/homework40/tasks.txt";
        boolean running = true;

        while (running) {
            switch (displayMenuAndGetChoice()) {
                case 1:
                    addNewTaskToFile(filePath, enterNewTask());
                    break;
                case 2:
                    printTasksFromFile(filePath);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static int displayMenuAndGetChoice() {
        System.out.println("Choose an option:");
        System.out.println("1. Add new task");
        System.out.println("2. View all tasks");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static String enterNewTask() {
        System.out.print("Enter new task: ");
        String newTask = scanner.nextLine();
        return newTask;
    }

    public static void addNewTaskToFile(String filePath, String newTask) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write("\n" + newTask);
            System.out.println("Task " + newTask + " added successfully!");
            fileWriter.close();
        }
        catch (IOException exception) {
            System.out.println("Error writing to file");
            exception.printStackTrace();
        }
    }

    public static void printTasksFromFile(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine())!= null) {
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
