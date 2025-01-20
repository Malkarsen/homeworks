package de.lessons.abstractclass_lesson31.example1;

public class Instagram extends SocialMedia {

    public Instagram(String userName) {
        super(userName);
    }

    @Override
    public void postContent(String content) {
        System.out.println(getUserName() + " posted: " + content + " on Instagram");
    }
}
