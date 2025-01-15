package de.lessons.interfaces_lesson30;

public class FacebookAuth implements SocialAuth {
    private String token;


    @Override
    public void authenticate(String userCredentials) {
        // userCredentials --> токен доступа
        this.token = userCredentials;
        System.out.println("Авторизация через Facebook с токеном " + token);
    }

    @Override
    public String getUserProfile() {
        return "Facebook-профиль пользователя с токеном " + token;
    }

    // переопределение default-метода интерфейса (контракта) не обязательно
    @Override
    public boolean checkLoginAttempts(int currentAttempt) {
        if (currentAttempt <= 2) {
            System.out.println("Facebook попытка входа допустима");
            return true;
        } else {
            System.out.println("Facebook попытка входа превышена");
            return false;
        }
    }
}
