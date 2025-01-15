package de.lessons.interfaces_lesson30;

public class SocialUser implements SocialAuth, SocialSharing{
    private String token;

    @Override
    public void authenticate(String userCredentials) {
        this.token = userCredentials;
        System.out.println("Универсальная авторизация с общим токеном: " + token);
    }

    @Override
    public String getUserProfile() {
        return "Универсальный профиль (токен: " + token + ")";
    }

    @Override
    public void postMessage(String message) {
        System.out.println("Отправляем сообщение: " + message + " с помощью токена " + token);
    }
}
