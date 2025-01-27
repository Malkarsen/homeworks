package de.lessons.propertyApp_lesson32;

public interface Property {
    double calculatePrice(); // метод для расчета цены недвижимости

    void printDetails(); // метод для вывода информации о недвижимости

    String getAddress(); // метод для получения адреса недвижимости

    boolean checkProperty(Property property);
}
