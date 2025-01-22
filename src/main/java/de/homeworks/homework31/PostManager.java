package de.homeworks.homework31;

public class PostManager {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice();
        Letter letter = new Letter("Anna", "Jane", 2.3, true);
        Package package1 = new Package("Bob", "Alice", 5.7, 20, 30, 10);
        Advertisement advertisement = new Advertisement("Charlie", "David", 1.2, 104);

        postOffice.addMailItem(letter);
        postOffice.addMailItem(package1);
        postOffice.addMailItem(advertisement);

        postOffice.printAllDetails();
        postOffice.calculateTotalShippingCost();
    }
}
