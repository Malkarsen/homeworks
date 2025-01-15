package de.lessons.interfaces_lesson30;

public interface Notifiable {
    void sendNotification(String userId, String message);

    default void checkNotificationStatus() {
        System.out.println("Проверяем, были ли все уведомления доставлены...");
    }

    static void printNotificationSettings() {
        System.out.println("Показать текущие настройки уведомления");
    }
}
