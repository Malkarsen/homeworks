package de.lessons.propertyApp_lesson32;

import java.util.List;

public class PropertyManager {
    public static void main(String[] args) {
        Property apartment = new Apartment("Main street", 4, 100, true);
        Property house = new House("House Street", 200, 200, false);
        Property office = new CommercialProperty("Office Street", 300, "Office");
        Property warehouse = new CommercialProperty("Warehouse Street", 30, "Warehouse");

        RealEstateAgency realEstateAgency = new RealEstateAgency();
        realEstateAgency.addProperty(apartment);
        realEstateAgency.addProperty(house);
        realEstateAgency.addProperty(office);
        realEstateAgency.addProperty(warehouse);

        realEstateAgency.printAllDetails();
        realEstateAgency.calculateTotalPrice();

        int rangeStart = 1000;
        int rangeEnd = 100000;
        List<Property> filteredByPriceRange = realEstateAgency.filterByPriceRange(rangeStart, rangeEnd);
        if (filteredByPriceRange != null) {
            System.out.println("Filtered properties by price range (from " + rangeStart + " to " + rangeEnd + "):");
            for (Property property : filteredByPriceRange) {
                property.printDetails();
                System.out.println("---------------");
            }
        }
        System.out.println("*************************");
        String typeName = "Office";
        List<Property> filteredByType = realEstateAgency.filterByType(typeName);
        if (filteredByType != null) {
            System.out.println("Filtered properties by type " + typeName + ":");
            for (Property property : filteredByType) {
                property.printDetails();
                System.out.println("---------------");
            }
        }
        System.out.println("*************************");
        realEstateAgency.sortPropertiesByPrice("-");
        System.out.println("Sorted properties by price (descending order):");
        for (Property property : realEstateAgency.getProperties()) {
            property.printDetails();
            System.out.println("---------------");
        }
    }
}
