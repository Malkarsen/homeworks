package de.homeworks.homework31;

public class PostManager {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice();
        postOffice.addMailItem(new Letter("Anna", "Jane", 2.3, true));
        postOffice.addMailItem(new Package("Bob", "Alice", 5.7, 20, 30, 10));
        postOffice.addMailItem(new Advertisement("Charlie", "David", 1.2, 104));

        postOffice.printAllDetails();
        postOffice.calculateTotalShippingCost();
    }
}
