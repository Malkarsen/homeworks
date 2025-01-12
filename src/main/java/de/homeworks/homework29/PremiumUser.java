package de.homeworks.homework29;

import java.time.LocalDate;

public class PremiumUser extends User{
    private LocalDate subscriptionEndDate;

    public PremiumUser(String id, String name, String email, LocalDate subscriptionEndDate) {
        super(id, name, email);
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public LocalDate getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public boolean isSubscriptionActive() {
        LocalDate today = LocalDate.now();
        return subscriptionEndDate.isAfter(today);
    }

    @Override
    public void printInfo() {
        System.out.println("Type: Premium user" +
                ", ID: " + getId() +
                ", Name: " + getName() +
                ", Email: " + getEmail() +
                ", Subscription End Date: " + subscriptionEndDate);
    }
}
