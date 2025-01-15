package de.lessons.interfaces_lesson30;

public class EmailNotifier implements Notifiable{
    @Override
    public void sendNotification(String userId, String message) {
        System.out.println("Отправляем email пользователю: " + userId + ", текст уведомления: " + message);
    }
}
