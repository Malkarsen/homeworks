package de.homeworks.homework43;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Cart<T extends Product> {
    private List<T> products = new ArrayList<T>();

    public void addProduct(T product) {
        products.add(product);
        log.info("Product '{}' added to the cart.", product.getName());
    }

    public T removeProduct(String productName) {
        for (T product : products) {
            if (product.getName().equals(productName)) {
                products.remove(product);
                log.info("Product '{}' removed from the cart.", productName);
                return product;
            }
        }
        log.error("Product '{}' not found in the cart.", productName);
        return null;
    }

    public boolean removeProductByName(String productName) {
        Iterator<T> iterator = products.iterator();
        while (iterator.hasNext()) {
            T currentProduct = iterator.next();
            if(productName.equals(currentProduct.getName())){
                iterator.remove();
                log.info("Product {} removed from cart", productName);
                return true;
            }
        }
        return false;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (T product : products) {
            totalPrice += product.getPrice();
        }
        log.info("Total price of the cart: {}", totalPrice);
        return totalPrice;
    }

    public void printAllProductsInfo() {
        if (!products.isEmpty()) {
            int i = 1;
            for (T product : products) {
                System.out.println(i + ". " + product.getDescription());
                i++;
            }
        } else {
            log.info("Cart is empty.");
            System.out.println("Cart is empty");
        }
    }

    public List<T> sortCartByPrice() {
        return products.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<T> filterProductsByPriceRange(double minPrice, double maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice() > minPrice && product.getPrice() < maxPrice)
                .collect(Collectors.toList());
    }

    public T getProductWithMinPrice() {
        return products.stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }

    public T getProductWithMaxPrice() {
        return products.stream()
               .max(Comparator.comparingDouble(Product::getPrice))
               .orElse(null);
    }

    public List<T> filterProductsByFirstLetterOfName(String firstLetter) {
        return products.stream()
                .filter((product -> product.getName().toUpperCase().startsWith(
                        firstLetter.trim().toUpperCase())))
                .collect(Collectors.toList());
    }

    public List<T> filterProductsBySubstringInName(String substring) {
        return products.stream()
                .filter((product -> product.getName().toUpperCase().contains(
                        substring.trim().toUpperCase())))
                .collect(Collectors.toList());
    }

    public List<T> filterProductsByExactName(String name) {
        return products.stream()
               .filter((product -> product.getName().equalsIgnoreCase(name)))
               .collect(Collectors.toList());
    }
}