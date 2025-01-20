package de.lessons.abstractclass_lesson31.example1;

public abstract class SocialMedia {
    private String userName;

    public SocialMedia(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    //Абстрактный метод: наследники обязаны его реализовать
    public abstract void postContent(String content);

    //Обычный метод: работает одинаково для всех наследников
    public void likePost() {
        System.out.println(userName + " likes the post");
    }
}
