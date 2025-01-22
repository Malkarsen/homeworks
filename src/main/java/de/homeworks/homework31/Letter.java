package de.homeworks.homework31;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Letter extends MailItem {
    private boolean isRegistered; // регистрированное письмо или нет

    public Letter(String sender, String recipient, double weight, boolean isRegistered) {
        super(sender, recipient, weight);
        this.isRegistered = isRegistered;
    }

    public boolean getIsRegistered() {
        return isRegistered;
    }

    @Override
    public double calculateShippingCost() {
        if (isRegistered) {
            return 10;
        } else {
            return 5;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Letter:");
        super.printDetails();
        if(isRegistered) {
            System.out.println("Registered: Yes");
        } else {
            System.out.println("Registered: No");
        }
        System.out.println("Shipping cost: " + calculateShippingCost() + " euros");
        System.out.println("--------------");
    }
}
