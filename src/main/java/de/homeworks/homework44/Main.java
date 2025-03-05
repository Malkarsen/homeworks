package de.homeworks.homework44;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Library<PaperBook> paperBookLibrary = new Library<>();
        PaperBook book = new PaperBook(faker.book().title(), faker.book().author(), 300);
        PaperBook book2 = new PaperBook(faker.book().title(), faker.book().author(), 278);
        PaperBook book3 = new PaperBook(faker.book().title(), faker.book().author(), 521);
        PaperBook book4 = new PaperBook(faker.book().title(), faker.book().author(), 436);
        PaperBook book5 = new PaperBook(faker.book().title(), faker.book().author(), 158);
        paperBookLibrary.addBook(book);
        paperBookLibrary.addBook(book2);
        paperBookLibrary.addBook(book3);
        paperBookLibrary.addBook(book4);
        paperBookLibrary.addBook(book5);
        paperBookLibrary.listBooks();
        PaperBook foundBook = paperBookLibrary.findBook(book3.getTitle());
        if (foundBook!= null) {
            System.out.println("The found book: " + foundBook.getTitle());
        } else {
            System.out.println("The book was not found.");
        }

        System.out.println("--------------------------------");

        Library<EBook> eBookLibrary = new Library<>();
        EBook eBook = new EBook(faker.book().title(), faker.book().author(), 240);
        EBook eBook2 = new EBook(faker.book().title(), faker.book().author(), 180);
        EBook eBook3 = new EBook(faker.book().title(), faker.book().author(), 360);
        EBook eBook4 = new EBook(faker.book().title(), faker.book().author(), 210);
        EBook eBook5 = new EBook(faker.book().title(), faker.book().author(), 120);
        eBookLibrary.addBook(eBook);
        eBookLibrary.addBook(eBook2);
        eBookLibrary.addBook(eBook3);
        eBookLibrary.addBook(eBook4);
        eBookLibrary.addBook(eBook5);
        eBookLibrary.removeBook(eBook4.getTitle());
        eBookLibrary.listBooks();
    }
}
