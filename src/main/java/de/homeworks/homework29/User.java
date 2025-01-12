package de.homeworks.homework29;

import java.util.ArrayList;

public class User {
    private String id; // уникальный идентификатор пользователя
    private String name; // имя пользователя
    private String email; // электронная почта
    private ArrayList<User> friends; // список друзей пользователя
    private ArrayList<Post> posts; // список постов пользователя

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<User> getFriends() {
        return new ArrayList<>(friends);
    }

    public ArrayList<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public void addFriend(User user) {
        if (user == null) {
            System.out.println("User is null");
        } else if (user.getId() == null || user.getName() == null
                || user.getEmail() == null) {
            System.out.println("User is invalid");
        } else if (friends.contains(user)) {
            System.out.println("User is already friend");
        } else {
            friends.add(user);
            System.out.println("Friend " + user.getName() + " added to " + getName());
        }
    }

    public void removeFriend(User user) {
        if (user == null) {
            System.out.println("User is null");
        } else if (user.getId() == null || user.getName() == null
                || user.getEmail() == null) {
            System.out.println("User is invalid");
        } else if (!friends.contains(user)) {
            System.out.println("User is not in the list");
        } else {
            friends.remove(user);
            System.out.println(getName() + "'s friend " + user.getName() + " removed");
        }
    }

    public Post createPost(String content) {
        if (content == null || content.isEmpty()) {
            System.out.println("Content is null or empty");
            return null;
        } else {
            System.out.println("Post created by " + getName());
            Post post = new Post(getName(), content);
            posts.add(post); // добавляем пост в список постов пользователя
            return post;
        }
    }

    public void viewFriendsPosts() {
        System.out.println("Posts by " + getName() + "'s friends: ");
        for (User friend : friends) {
            if (friend.getPosts().isEmpty()) {
                System.out.println("Friend " + friend.getName() + " has no posts");
            } else {
                System.out.println("Posts by " + friend.getName() + ":");
                for (Post post : friend.getPosts()) {
                    System.out.println("- " + post.getContent());
                }
            }
        }
    }

    public void printInfo() {
        System.out.println("Type: User" +
                ", ID: " + id +
                ", Name: " + name +
                ", Email: " + email);
        if (!friends.isEmpty()) {
            System.out.print("Friends: ");
            for (User friend : friends) {
                System.out.println("- " + friend.getName());
            }
        }
        if (!posts.isEmpty()) {
            System.out.print("Posts: ");
            for (Post post : posts) {
                System.out.println("- Content: " + post.getContent()
                        + ", Likes: " + post.getLikes());
            }
        }
    }
}
