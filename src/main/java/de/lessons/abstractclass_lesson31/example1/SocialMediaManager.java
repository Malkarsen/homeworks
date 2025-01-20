package de.lessons.abstractclass_lesson31.example1;

public class SocialMediaManager {
    public static void main(String[] args) {
        SocialMedia facebookUser = new Facebook("facebookUser");
        facebookUser.postContent("i love my new job");
        facebookUser.likePost();
        System.out.println("----------");

        SocialMedia instagramUser = new Instagram("instagramUser");
        instagramUser.postContent("I love my new cat");
        instagramUser.likePost();

    }
}
