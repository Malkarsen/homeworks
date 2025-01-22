package de.homeworks.homework31;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Advertisement extends MailItem {
    private int quantity; // количество копий
    private final int QUANTITY_PER_1_EURO = 50;
    private final double PRICE_PER_50_ITEM = 50;

    public Advertisement(String sender, String recipient, double weight, int quantity) {
        super(sender, recipient, weight);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double calculateShippingCost() {
        if (quantity < QUANTITY_PER_1_EURO) {
            return 0;
        } else {
            return Math.ceil((double) quantity / QUANTITY_PER_1_EURO) * PRICE_PER_50_ITEM;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Advertisement:");
        super.printDetails();
        System.out.println("Quantity: " + quantity);
        System.out.println("Shipping cost: " + calculateShippingCost() + " euros");
        System.out.println("--------------");
    }
}
