package de.homeworks.homework29;

public class FriendsUndPostsManager {
    public static void main(String[] args) {
        User userJohn = new User("1", "John Doe", "johndoe@example.com");
        User userJane = new User("2", "Jane Doe", "janedoe@example.com");

        userJohn.addFriend(userJane);
        userJane.addFriend(userJohn);
        System.out.println("---------------------------------");

        Post johnPost = userJohn.createPost("Hello, Jane!");
        johnPost.like();
        userJohn.printInfo();
        System.out.println("---------------------------------");

        Post janePost = userJane.createPost("Hi, John!");
        janePost.like();
        userJane.printInfo();
        System.out.println("---------------------------------");

        userJohn.viewFriendsPosts();
        System.out.println("---------------------------------");
        userJane.viewFriendsPosts();
        System.out.println("---------------------------------");

        userJohn.removeFriend(userJane);
        userJane.removeFriend(userJohn);
    }
}
