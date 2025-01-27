package de.homeworks.homework33;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GiftManager {
    private ArrayList<Gift> gifts;

    public GiftManager() {
        this.gifts = new ArrayList<>();
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<>(gifts);
    }

    // добавляет подарок в список
    public void addGift(Gift gift) {
        if (gift == null) {
            System.out.println("Gift is null");
            log.warn("Gift is null");
        } else if (gift.getName() == null || gift.getName().isEmpty()
                || gift.getCategory() == null
                || gift.getStatus() == null) {
            System.out.println("Gift is invalid");
            log.warn("Gift is invalid");
        } else if (gifts.contains(gift)) {
            System.out.println("Gift is already present");
            log.warn("Gift is already present");
        } else {
            gifts.add(gift);
            System.out.println("Gift added: " + gift.getName());
            log.info("Gift added: {}", gift.getName());
        }
    }

    // возвращает список подарков по указанной категории
    public ArrayList<Gift> filterByCategory(GiftCategory category) {
        ArrayList<Gift> filteredGifts = new ArrayList<>();
        if (gifts.isEmpty()) {
            System.out.println("No items in list");
            return null;
        } else {
            for (Gift gift : gifts) {
                if (gift.getCategory().equals(category)) {
                    filteredGifts.add(gift);
                }
            }
            return filteredGifts;
        }
    }

    // обновляет статус подарка по его имени
    public void updateGiftStatus(String giftName, GiftStatus newStatus) {
        boolean isGiftPresent = false;
        if (gifts.isEmpty()) {
            System.out.println("No items in list");
        } else {
            for (Gift gift : gifts) {
                if (gift.getName().equals(giftName)) {
                    gift.setStatus(newStatus);
                    System.out.println("Gift: " + gift.getName() + " - status changed");
                    isGiftPresent = true;
                }
            }
            if (!isGiftPresent) {
                System.out.println("No items with name: " + giftName);
            }
        }
    }

    public boolean isCategoryPresent(String categoryName) {
        try {
            GiftCategory.valueOf(categoryName);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean isStatusPresent(String statusName) {
        try {
            GiftStatus.valueOf(statusName);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
