package de.homeworks.homework31;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Package extends MailItem {
    // размеры посылки в см
    private double length;
    private double width;
    private double height;
    private double priceKilogram = 2.0;

    public Package(String sender, String recipient, double weight,
                   double length, double width, double height) {
        super(sender, recipient, weight);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateShippingCost() {
        if (getWeight() <= 0) {
            return 0;
        } else {
            return getWeight() * priceKilogram;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Package:");
        super.printDetails();
        System.out.println("Length: " + length + " cm\n" +
                "Width - " + width + " cm\n" + "Height - " + height + " cm" );
        System.out.println("Shipping cost: " + calculateShippingCost() + " euros");
        System.out.println("--------------");
    }
}
