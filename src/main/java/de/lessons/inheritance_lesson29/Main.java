package de.lessons.inheritance_lesson29;

public class Main {
    public static void main(String[] args) {
        Book papierBook = new Book("The Hobbit", "J.R.R. Tolkien");
        papierBook.printInfo();
        papierBook.read();

        System.out.println("--------------------------------");
        EBook eBook = new EBook("1984", "George Orwell", 4);
        eBook.printInfo();
        eBook.read();
        eBook.download();

        System.out.println("--------------------------------");
        AudioBook audioBook = new AudioBook("Maori", "King", 360);
        audioBook.printInfo();
        audioBook.read();
        audioBook.listen();

        System.out.println("---------------ПОЛИМОРФИЗМ-----------------");
        Book anyBook = new EBook("anyTitle", "anyTitle", 10);
        anyBook.read();
    }
}
