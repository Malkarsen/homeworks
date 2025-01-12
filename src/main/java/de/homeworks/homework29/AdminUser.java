package de.homeworks.homework29;

import java.util.ArrayList;

public class AdminUser extends User {
    private ArrayList<User> bannedUsers;

    public AdminUser(String name, String id, String email) {
        super(name, id, email);
        this.bannedUsers = new ArrayList<>();
    }

    public ArrayList<User> getBannedUsers() {
        return new ArrayList<>(bannedUsers);
    }

    public void banUser(User user) {
        if (user == null) {
            System.out.println("User is null");
        } else if (user.getId() == null || user.getName() == null || user.getEmail() == null){
            System.out.println("Invalid user data");
        } else if (bannedUsers.contains(user)) {
            System.out.println("User is already banned");
        } else {
            bannedUsers.add(user);
            System.out.println("User " + user.getName() + " has been banned");
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Type: Admin user" +
                ", ID: " + getId() +
                ", Name: " + getName() +
                ", Email: " + getEmail() +
                ", Banned Users:");
        for (User user : bannedUsers) {
            System.out.print("- ");
            user.printInfo();
        }
    }
}
