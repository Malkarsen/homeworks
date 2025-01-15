package de.lessons.interfaces_lesson30;

public class MainAuth {
    public static void main(String[] args) {
        // выбираем Facebook ка способ авторизации
        SocialAuth facebookAuth = new FacebookAuth();
        facebookAuth.authenticate("fb_token_123456789");
        System.out.println(facebookAuth.getUserProfile());

        // Проверяем попытки входа
        facebookAuth.checkLoginAttempts(1);
        facebookAuth.checkLoginAttempts(3);
        System.out.println("--------------Google Auth-------------------");

        // Меняем способ авторизации на Google
        SocialAuth googleAuth = new GoogleAuth();
        googleAuth.authenticate("google_oauthtoken_56789");
        System.out.println(googleAuth.getUserProfile());
        boolean checkLoginAttempts = googleAuth.checkLoginAttempts(4);
        System.out.println("Допустима ли 4я попытка входа: " + checkLoginAttempts);

        SocialAuth.printMaxLoginAttempts();
    }
}
