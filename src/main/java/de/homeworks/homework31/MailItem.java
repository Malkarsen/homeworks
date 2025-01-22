package de.homeworks.homework31;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class MailItem {
    private String sender; // отправитель
    private String recipient; // получатель
    private double weight; // вес отправления в кг

    public MailItem(String sender, String recipient, double weight) {
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getWeight() {
        return weight;
    }

    // абстрактный метод для расчета стоимости доставки
    public abstract double calculateShippingCost();

    // обычный метод, который выводит информацию об отправлении, включая отправителя, получателя и вес.
    public void printDetails() {
        System.out.println("Sender: " + sender + "\nRecipient: " + recipient + "\nWeight: " + weight + "kg");
    }
}
