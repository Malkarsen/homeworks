package de.lessons.propertyApp_lesson32;

import de.homeworks.homework31.MailItem;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class RealEstateAgency {
    private List<Property> properties; // список объектов недвижимости

    public RealEstateAgency() {
        this.properties = new ArrayList<>();
    }

    public List<Property> getProperties() {
        return new ArrayList<>(properties);
    }

    // добавляет объект недвижимости в список
    public void addProperty(Property property) {
        if (property == null) {
            System.out.println("Property is null");
            log.warn("Property is null");
        } else {
            properties.add(property);
            System.out.println("Property was added");
            log.info("Property was added");
        }
    }

    // выводит общую стоимость всех объектов недвижимости
    public double calculateTotalPrice() {
        System.out.println("------------------------");
        if (properties.isEmpty()) {
            System.out.println("No properties found");
            log.warn("No properties found");
            return 0;
        } else {
            double totalPrice = 0;
            for (Property property : properties) {
                totalPrice += property.calculatePrice();
            }
            System.out.println("Total price: " + totalPrice + " euros");
            return totalPrice;
        }
    }

    // выводит информацию обо всех объектах недвижимости, используя метод printDetails()
    public void printAllDetails() {
        System.out.println("------------------------");
        if (properties.isEmpty()) {
            System.out.println("No properties found");
            log.warn("No properties found");
        } else {
            for (Property property : properties) {
                property.printDetails();
                System.out.println("--------------");
            }
        }
    }

    // фильтрация объектов недвижимости по минимальной и максимальной цене
    public List<Property> filterByPriceRange(double minPrice, double maxPrice) {
        if (properties.isEmpty()) {
            System.out.println("No properties found");
            log.warn("No properties found");
            return null;
        } else {
            List<Property> filteredProperties = new ArrayList<>();
            for (Property property : properties) {
                if (property.calculatePrice() >= minPrice && property.calculatePrice() <= maxPrice) {
                    filteredProperties.add(property);
                }
            }
            if (filteredProperties.isEmpty()) {
                System.out.println("No properties found within the given price range (from "
                        + minPrice + " to " + maxPrice + ")");
                log.warn("No properties found within the given price range (from {} to {})", minPrice, maxPrice);
                return null;
            }
            return filteredProperties;
        }
    }

    // фильтрация объектов недвижимости по типу недвижимости
    public List<Property> filterByType(String typeName) {
        if (properties.isEmpty()) {
            System.out.println("No properties found");
            log.warn("No properties found");
            return null;
        } else {
            List<Property> filteredProperties = new ArrayList<>();
            for (Property property : properties) {
                if (property instanceof CommercialProperty) {
                    // Приведение типа и доступ к специфическим методам
                    CommercialProperty commercial = (CommercialProperty) property;
                    String businessType = commercial.getBusinessType();
                    if (businessType.equals(typeName)) {
                        filteredProperties.add(property);
                    }
                }
            }
            if (filteredProperties.isEmpty()) {
                System.out.println("No properties found of type: " + typeName);
                log.warn("No properties found of type: {}", typeName);
                return null;
            }
            return filteredProperties;
        }
    }

    // сортировка объектов недвижимости по цене ('+' - по возрастанию, '-' - по убыванию)
    public void sortPropertiesByPrice(String sortOrder) {
        if (properties.isEmpty()) {
            System.out.println("No properties found");
            log.warn("No properties found");
        } else {
            if (sortOrder.equals("+")) {
                properties.sort(Comparator.comparingDouble(Property::calculatePrice));
            } else if (sortOrder.equals("-")) {
                properties.sort(Comparator.comparingDouble(Property::calculatePrice).reversed());
            } else {
                System.out.println("Invalid sort order: " + sortOrder);
                log.warn("Invalid sort order: {}", sortOrder);
            }
        }
    }
}
