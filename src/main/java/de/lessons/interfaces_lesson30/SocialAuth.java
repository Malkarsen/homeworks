package de.lessons.interfaces_lesson30;

public interface SocialAuth {
    // Абстрактные методы должны быть обязательно реализованы в классах,
    // методы по-умолчанию (Default) не обязательно,
    // статические не нужно
    // но есть возможность в классах использовать Default- и static-методы
    // Константа
    int MAX_LOGIN_ATTEMPTS = 3;

    // сигнатура метода без реализации
    // Абстрактный метод: как авторизоваться (обязательно такие методы должны быть реализованы в потомках)
    void authenticate(String userCredentials);

    // Абстрактный метод: получить профиль пользователя
    // (такие методы могут быть реализованы в потомках, но не обязательно)
    String getUserProfile();

    // От версии Java 8 можно добавить Default-метод: добавляем логику по умолчанию
    default boolean checkLoginAttempts(int currentAttempt) {
        return currentAttempt < MAX_LOGIN_ATTEMPTS;
    }

    // От версии Java 8 можно добавить Static-метод: общий вспомогательный метод
    static void printMaxLoginAttempts() {
        System.out.println("Максимальное количество попыток входа " + MAX_LOGIN_ATTEMPTS);;
    }
}
