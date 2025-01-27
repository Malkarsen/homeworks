package de.homeworks.homework33;

import java.util.Objects;

public class Gift {
    private String name; // название подарка
    private GiftCategory category; // категория подарка (используйте enum GiftCategory)
    private GiftStatus status; // статус подарка (используйте enum GiftStatus

    public Gift(String name, String category, String status) {
        this.name = name;
        this.category = GiftCategory.valueOf(category);
        this.status = GiftStatus.valueOf(status);
    }

    public String getName() {
        return name;
    }

    public GiftCategory getCategory() {
        return category;
    }

    public GiftStatus getStatus() {
        return status;
    }

    public void setStatus(GiftStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(name, gift.name) && category == gift.category && status == gift.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, status);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", category=" + category +
                ", status=" + status;
    }
}
