package de.homeworks.homework43;

import java.util.List;

public class AmazonStoreApp {
    public static void main(String[] args) {
        Cart<Book> bookCart = new Cart<>();
        bookCart.addProduct(new Book("1984", 8.75, "George Orwell"));
        bookCart.addProduct(new Book("To Kill a Mockingbird", 9.99, "Harper Lee"));
        bookCart.addProduct(new Book("The Great Gatsby", 12.99, "F. Scott Fitzgerald"));
        bookCart.addProduct(new Book("Dune", 16.0, "Frank Herbert"));
        bookCart.addProduct(new Book("The Alchemist", 9.99, "Paulo Coelho"));
        System.out.println("Total price before removing book: "
                + getFormattedDoubleValue(bookCart.getTotalPrice()));
        System.out.println("List of books before removing book: ");
        bookCart.printAllProductsInfo();
        System.out.println("-------------------------------");

        bookCart.removeProduct("1984");
        System.out.println("Total price after removing book: "
                + getFormattedDoubleValue(bookCart.getTotalPrice()));
        System.out.println("List of books after removing book: ");
        bookCart.printAllProductsInfo();
        System.out.println("-------------------------------");
        List<Book> sortedBookCart = bookCart.sortCartByPrice();
        System.out.println("Sorted books by price (ascending order):");
        printList(sortedBookCart);
        System.out.println("-------------------------------");

        // 1
        double minRangeBook = 10.0;
        double maxRangeBook = 13.0;
        List<Book> filteredBookCart1 = bookCart.filterProductsByPriceRange(minRangeBook, maxRangeBook);
        System.out.println("Filtered books by price range (" + minRangeBook + " to " + maxRangeBook + "):");
        printList(filteredBookCart1);
        // 2
        String bookName = "dune";
        List<Book> filteredBookCart2 = bookCart.filterProductsByExactName(bookName);
        System.out.println("Filtered books by exact name '" + bookName + "':");
        printList(filteredBookCart2);
        // 3
        String firstLetterBook = "t";
        List<Book> filteredBookCart3 = bookCart.filterProductsByFirstLetterOfName(firstLetterBook);
        System.out.println("Filtered books by first letter of name '" + firstLetterBook + "':");
        printList(filteredBookCart3);
        // 4
        String substringBook = "the";
        List<Book> filteredBookCart4 = bookCart.filterProductsBySubstringInName(substringBook);
        System.out.println("Filtered books by substring '" + substringBook + "':");
        printList(filteredBookCart4);
        // 5
        System.out.println("Book with min price: " + bookCart.getProductWithMinPrice().getDescription());
        // 6
        System.out.println("Book with max price: " + bookCart.getProductWithMaxPrice().getDescription());
        System.out.println("****************");
        System.out.println();

        Cart<Electronics> electronicsCart = new Cart<>();
        electronicsCart.addProduct(new Electronics("iPhone 12", 999.99, "Apple"));
        electronicsCart.addProduct(new Electronics("Samsung Galaxy S21", 1199.99, "Samsung"));
        electronicsCart.addProduct(new Electronics("PlayStation 5", 549.99, "Sony"));
        electronicsCart.addProduct(new Electronics("OLED 4K Smart TV 65-inch", 1299.99, "LG"));
        electronicsCart.addProduct(new Electronics("GoPro HERO12 Black", 449.99, "GoPro"));
        System.out.println("Total price before removing electronics: "
                + getFormattedDoubleValue(electronicsCart.getTotalPrice()));
        System.out.println("List of books before removing electronics: ");
        electronicsCart.printAllProductsInfo();
        System.out.println("-------------------------------");
        electronicsCart.removeProduct("GoPro HERO12 Black");
        System.out.println("Total price after removing electronics: "
                + getFormattedDoubleValue(electronicsCart.getTotalPrice()));
        System.out.println("List of books after removing electronics: ");
        electronicsCart.printAllProductsInfo();
        System.out.println("-------------------------------");
        List<Electronics> sortedElectronicsCart = electronicsCart.sortCartByPrice();
        System.out.println("Sorted electronics by price (ascending order):");
        printList(sortedElectronicsCart);

        // 1
        double minRange = 500.0;
        double maxRange = 1000.0;
        List<Electronics> filteredElectronicsCart1 = electronicsCart.filterProductsByPriceRange(minRange, maxRange);
        System.out.println("Filtered electronics by price range (" + minRange + " to " + maxRange + "):");
        printList(filteredElectronicsCart1);
        // 2
        String electronicsName = "iPhone 12";
        List<Electronics> filteredElectronicsCart2 = electronicsCart.filterProductsByExactName(electronicsName);
        System.out.println("Filtered electronics by exact name '" + electronicsName + "':");
        printList(filteredElectronicsCart2);
        // 3
        String firstLetter = "p";
        List<Electronics> filteredElectronicsCart3 = electronicsCart.filterProductsByFirstLetterOfName(firstLetter);
        System.out.println("Filtered electronics by first letter of name '" + firstLetter + "':");
        printList(filteredElectronicsCart3);
        // 4
        String substring = "oled";
        List<Electronics> filteredElectronicsCart4 = electronicsCart.filterProductsBySubstringInName(substring);
        System.out.println("Filtered electronics by substring '" + substring + "':");
        printList(filteredElectronicsCart4);
        // 5
        System.out.println("Electronics with min price: "
                + electronicsCart.getProductWithMinPrice().getDescription());
        // 6
        System.out.println("Electronics with max price: "
                + electronicsCart.getProductWithMaxPrice().getDescription());

    }

    public static String getFormattedDoubleValue(double value) {
        return String.format("%.2f", value);
    }

    public static void printList(List<?> list) {
        if (!list.isEmpty()) {
            int i = 1;
            for (Object item : list) {
                System.out.println(i + ". " + item);
                i++;
            }
        } else {
            System.out.println("No items found");
        }
    }
}