package de.lessons.abstractclass_lesson31.example2;

public class AdminUser extends User {
    public AdminUser(String name, int id) {
        super(name, id);
    }

    @Override
    public void performAction() {
        System.out.println(getName() + " checked news");
    }
}
