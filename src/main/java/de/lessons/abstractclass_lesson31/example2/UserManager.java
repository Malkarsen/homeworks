package de.lessons.abstractclass_lesson31.example2;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new RegularUser("John", 1));
        users.add(new AdminUser("Max", 2));

        for (User user : users) {
            user.performAction();
        }
    }
}
