package de.lessons.abstractclass_lesson31.example2;

public class RegularUser extends User {
    public RegularUser(String name, int id) {
        super(name, id);
    }

    @Override
    public void performAction() {
        System.out.println(getName() + " read news");
    }
}
