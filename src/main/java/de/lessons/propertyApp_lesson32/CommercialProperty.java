package de.lessons.propertyApp_lesson32;

public class CommercialProperty implements Property {
    private String officeType = "office";
    private String warehouseType = "warehouse";
    private String address; // адрес
    private double area; // площадь в квадратных метрах
    private String businessType; // тип бизнеса: офис, склад и т.д.

    public CommercialProperty(String address, double area, String businessType) {
        this.address = address;
        this.area = area;
        this.businessType = businessType;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public String getBusinessType() {
        return businessType;
    }

    @Override
    public double calculatePrice() {
        double price = 0;
        int officePricePerSquareMeter = 1500; // цена офиса за квадратный метр
        int warehousePricePerSquareMeter = 800; // цена склада за квадратный метр
        int otherPropertyPricePerSquareMeter = 1000; // цена других объектов за квадратный метр
        switch (businessType) {
            case "office":
                price = area * officePricePerSquareMeter;
                break;
            case "warehouse":
                price = area * warehousePricePerSquareMeter;
                break;
            default:
                price = area * otherPropertyPricePerSquareMeter;
                break;
            /*
            case "office" -> area * officePricePerSquareMeter;
            case "warehouse" -> area * warehousePricePerSquareMeter;
            default -> area * otherPropertyPricePerSquareMeter;
             */
        }
        return price;
    }

    @Override
    public void printDetails() {
        System.out.println("Commercial Property:");
        System.out.println("Address: " + address);
        System.out.println("Area: " + area + " square meters");
        System.out.println("Business type: " + businessType);
        System.out.println("Price: " + calculatePrice() + " euros");
    }
}
