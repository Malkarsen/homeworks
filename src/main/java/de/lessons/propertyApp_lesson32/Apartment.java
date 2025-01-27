package de.lessons.propertyApp_lesson32;

public class Apartment implements Property {
    private String address; // адрес
    private int floor; // этаж
    private double area; // площадь в квадратных метрах
    private boolean hasElevator; // наличие лифта

    public Apartment(String address, int floor, double area, boolean hasElevator) {
        this.address = address;
        this.floor = floor;
        this.area = area;
        this.hasElevator = hasElevator;
    }

    public boolean isHasElevator() {
        return hasElevator;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean checkProperty(Property property) {
        if (floor <= 0 || area <= 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public double calculatePrice() {
        int pricePerSquareMeter = 1000; // цена за квадратный метр
        double price = pricePerSquareMeter * area;
        if (hasElevator) {
            price *= 1.05;
        }
        return price;
    }

    @Override
    public void printDetails() {
        System.out.println("Apartment:");
        System.out.println("Address: " + address);
        System.out.println("Floor: " + floor);
        System.out.println("Area: " + area + " square meters");
        if (hasElevator) {
            System.out.println("Has elevator: Yes");
        } else {
            System.out.println("Has elevator: No");
        }
        System.out.println("Price: " + calculatePrice() + " euros");
    }
}
