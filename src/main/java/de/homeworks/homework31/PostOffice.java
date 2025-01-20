package de.homeworks.homework31;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PostOffice {
    private List<MailItem> mailItems; // список почтовых отправлений

    public PostOffice() {
        this.mailItems = new ArrayList<>();
    }

    public List<MailItem> getMailItems() {
        return new ArrayList<>(mailItems);
    }

    // добавляет отправление в список
    public void addMailItem(MailItem item) {
        if (item == null) {
            System.out.println("Mail item is null");
            log.warn("Mail item is null");
        } else if (item.getSender() == null || item.getRecipient() == null || item.getWeight() <= 0) {
            System.out.println("Mail item is invalid");
            log.warn("Mail item is invalid");
        } else {
            mailItems.add(item);
            System.out.println("Mail item added: From " + item.getSender() + ", To " + item.getRecipient());
            log.info("Mail item added: From {}, To {}", item.getSender(), item.getRecipient());
        }
    }

    // выводит общую стоимость доставки для всех отправлений в списке
    public double calculateTotalShippingCost() {
        double cost = 0;
        for (MailItem item : mailItems) {
            cost += item.calculateShippingCost();
        }
        System.out.println("Total shipping cost: " + cost + " euros");
        return cost;
    }

    // выводит информацию обо всех отправлениях, используя метод printDetails()
    public void printAllDetails() {
        for (MailItem item : mailItems) {
            item.printDetails();
        }
    }
}
