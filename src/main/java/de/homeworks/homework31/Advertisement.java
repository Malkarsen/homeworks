package de.homeworks.homework31;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Advertisement extends MailItem {
    private int quantity; // количество копий
    private final int QUANTITY_PER_1_EURO = 50;

    public Advertisement(String sender, String recipient, double weight, int quantity) {
        super(sender, recipient, weight);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double calculateShippingCost() {
        if (quantity < 50) {
            return 0;
        } else {
            return (double) quantity / 50;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Advertisement:");
        log.info("Advertisement:");
        super.printDetails();
        System.out.println("Quantity: " + quantity);
        log.info("Quantity: {}", quantity);
    }
}
