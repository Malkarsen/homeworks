package de.lessons.interfaces_lesson30;

public class NotificationManager {
    public static void main(String[] args) {
        Notifiable notifiable = new EmailNotifier();
        notifiable.sendNotification("user123", "Новое уведомление!");
        notifiable.checkNotificationStatus();

        Notifiable.printNotificationSettings();
        EmailNotifier emailNotifier = new EmailNotifier();
    }
}
