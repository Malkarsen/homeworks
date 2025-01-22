package de.lessons.propertyApp_lesson32;

public class House implements Property {
    private String address; // адрес
    private double area; // площадь дома в квадратных метрах
    private double landArea; // площадь участка в квадратных метрах
    private boolean hasGarage; // наличие гаража

    public House(String address, double area, double landArea, boolean hasGarage) {
        this.address = address;
        this.area = area;
        this.landArea = landArea;
        this.hasGarage = hasGarage;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public double getLandArea() {
        return landArea;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    @Override
    public double calculatePrice() {
        int housePricePerSquareMeter = 800; // цена дома за квадратный метр
        int areaPricePerSquareMeter = 200; // цена участка за квадратный метр
        double price = housePricePerSquareMeter * area + areaPricePerSquareMeter * landArea;
        if (hasGarage) {
            price += 5000;
        }
        return price;
    }

    @Override
    public void printDetails() {
        System.out.println("House:");
        System.out.println("Address: " + address);
        System.out.println("Area: " + area + " square meters");
        System.out.println("Land area: " + landArea + " square meters");
        if (hasGarage) {
            System.out.println("Has garage: Yes");
        } else {
            System.out.println("Has garage: No");
        }
        System.out.println("Price: " + calculatePrice() + " euros");
    }
}
