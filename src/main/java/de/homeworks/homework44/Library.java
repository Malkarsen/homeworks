package de.homeworks.homework44;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class Library<T extends Book> {
    private List<T> books = new ArrayList<>();

    // добавить книгу в библиотеку
    public void addBook(T book) {
        books.add(book);
        log.info("Book '{}' added to the library", book.getTitle());
    }

    // найти книгу по названию и удалить, если такая есть
    public boolean removeBook(String title) {
        if (!books.isEmpty()) {
            Iterator<T> iterator = books.iterator();
            while (iterator.hasNext()) {
                T book = iterator.next();
                if (book.getTitle().equalsIgnoreCase(title)) {
                    iterator.remove();
                    log.info("Book '{}' removed from the library", book.getTitle());
                    return true;
                }
            }
            log.warn("Book '{}' not found in the library", title);
        } else {
            log.warn("No books found in the library");
        }
        return false;
    }

    // вернуть книгу по названию (или null, если не найдена)
    public T findBook(String title) {
        if (!books.isEmpty()) {
            for (T book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    return book;
                }
            }
            log.warn("Book '{}' not found in the library", title);
        } else {
            log.warn("No books found in the library");
        }
        return null;
    }

    // вывести getDescription() для каждой книги в библиотеке
    public void listBooks() {
        if (!books.isEmpty()) {
            System.out.println("List of books in the library:");
            int i = 1;
            for (T book : books) {
                System.out.println(i + ". " + book.getDescription());
                i++;
            }
        } else {
            log.warn("List is empty");
        }
    }
}
