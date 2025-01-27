package de.homeworks.homework33;

import java.util.ArrayList;
import java.util.Scanner;

public class GiftApp {
    static Scanner scanner = new Scanner(System.in);
    static GiftManager giftManager = new GiftManager();
    public static void main(String[] args) {

        boolean exit = false;
        do {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addNewGift();
                    break;
                case 2:
                    showAllGifs();
                    break;
                case 3:
                    filterGiftsByCategory();
                    break;
                case 4:
                    updateGiftStatus();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (!exit);
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("Welcome to the Gift Management System!");
        System.out.println("Choose an action:");
        System.out.println("1 - Add a new gift");
        System.out.println("2 - Show all gifts");
        System.out.println("3 - Filter gifts by category");
        System.out.println("4 - Update gift status");
        System.out.println("5 - Exit");
    }

    private static int getChoice() {
        System.out.print("Choose an action: ");
        return scanner.nextInt();
    }

    // 1
    private static void addNewGift() {
        String name = inputGiftName(
                "Enter the gift name: ");
        String category = inputGiftCategory(
                "Select the category (ELECTRONICS, TOYS, BOOKS, CLOTHING, HOME_APPLIANCES): ");
        String status = inputGiftStatus(
                "Select the status (AVAILABLE, OUT_OF_STOCK, RESERVED, DELIVERED): ");

        giftManager.addGift(new Gift(name, category, status));
    }

    // 2
    private static void showAllGifs() {
        ArrayList<Gift> gifts = giftManager.getGifts();
        if (gifts.isEmpty()) {
            System.out.println("No gifts found.");
        } else {
            System.out.println("List of all gifts:");
            printArray(gifts);
        }
    }

    // 3
    private static void filterGiftsByCategory() {
        if (giftManager.getGifts().isEmpty()) {
            System.out.println("No gifts in the list");
        } else {
            String category = inputGiftCategory(
                    "Enter the category to filter (ELECTRONICS, TOYS, BOOKS, CLOTHING, HOME_APPLIANCES): ");
            ArrayList<Gift> filteredGifts = giftManager.filterByCategory(GiftCategory.valueOf(category));
            if (filteredGifts == null || filteredGifts.isEmpty()) {
                System.out.println("No gifts found in category: " + category);
            } else {
                System.out.println("Filter results (category: " + category + "):");
                printArray(filteredGifts);
            }
        }
    }

    // 4
    private static void updateGiftStatus() {
        if (giftManager.getGifts().isEmpty()) {
            System.out.println("No gifts in the list");
        } else {
            String giftName = inputGiftName(
                    "Enter the gift name to update its status: ");
            String newStatus = inputGiftStatus(
                    "Select the new status (AVAILABLE, OUT_OF_STOCK, RESERVED, DELIVERED): ");

            giftManager.updateGiftStatus(giftName, GiftStatus.valueOf(newStatus));
        }
    }

    private static String inputGiftName(String message) {
        String name;
        boolean isNameValid = false;
        do {
            System.out.print(message);
            name = scanner.next();
            if (!name.trim().isEmpty()) {
                isNameValid = true;
            } else {
                System.out.println("Gift name cannot be empty!");
            }
        } while (!isNameValid);
        return name;
    }

    private static String inputGiftCategory(String message) {
        String category;
        boolean isCategoryPresent = false;
        do {
            System.out.print(message);
            category = scanner.next();
            if (giftManager.isCategoryPresent(category)) {
                isCategoryPresent = true;
            } else {
                System.out.println("Invalid category!");
            }
        } while (!isCategoryPresent);
        return category;
    }

    private static String inputGiftStatus(String message) {
        String status;
        boolean isStatusPresent = false;
        do {
            System.out.print(message);
            status = scanner.next();
            if (giftManager.isStatusPresent(status)) {
                isStatusPresent = true;
            } else {
                System.out.println("Invalid status!");
            }
        } while (!isStatusPresent);
        return status;
    }

    private static void printArray(ArrayList<Gift> gifts) {
        int index = 1;
        for (Gift gift : gifts) {
            System.out.println(index + ". " + gift);
            index++;
        }
    }
}
