package de.lessons.abstractclass_lesson31.example1;

public class Facebook extends SocialMedia {
    public Facebook(String userName) {
        super(userName);
    }

    @Override
    public void postContent(String content) {
        System.out.println(getUserName() + " posted: " + content + " on Facebook");
    }
}
