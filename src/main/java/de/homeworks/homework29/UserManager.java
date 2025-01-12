package de.homeworks.homework29;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserManager {
    public static void main(String[] args) {
        User userJohn = new User("1", "John Doe", "johndoe@example.com");
        PremiumUser premiumUserJane = new PremiumUser("2", "Jane Doe", "janedoe@example.com",
                LocalDate.of(2025, 12, 31));
        AdminUser adminUser = new AdminUser("admin", "Admin", "admin@example.com");

        userJohn.printInfo();
        premiumUserJane.printInfo();
        adminUser.printInfo();

        System.out.println("User: " + premiumUserJane.getName() +
                ", Is subscription active: " + premiumUserJane.isSubscriptionActive());
        adminUser.banUser(premiumUserJane);

        System.out.println("User name: " + userJohn.getName());
        System.out.println("Premium User name: " + premiumUserJane.getName());
        System.out.println("Admin User name: " + adminUser.getName());

        ArrayList<User> bannedUser = adminUser.getBannedUsers();
        System.out.println("Banned users:");
        for (User user : bannedUser) {
            user.printInfo();
        }

    }
}
