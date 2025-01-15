package de.homeworks.homework30.task2;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class MessengerManager {
    public static void main(String[] args) {
        UserMessenger userMessenger = new UserMessenger();

        userMessenger.sendMessage("Hello, User 2!", "user1");
        userMessenger.sendMessage("Hello, User 3!", "user2");
        userMessenger.sendMessage("Hello, User 1!", "user3");

        if (!userMessenger.receiveMessages("user1").isEmpty()) {
            System.out.println("User 1 received messages: ");
            log.info("User 1 received messages: ");
            for (String message : userMessenger.receiveMessages("user1")) {
                System.out.println(message);
                log.info(message);
            }
        }

        if (!userMessenger.receiveMessages("user2").isEmpty()) {
            System.out.println("User 2 received messages: ");
            log.info("User 2 received messages: ");
            for (String message : userMessenger.receiveMessages("user1")) {
                System.out.println(message);
                log.info(message);
            }
        }

        if (!userMessenger.receiveMessages("user3").isEmpty()) {
            System.out.println("User 3 received messages: ");
            log.info("User 3 received messages: ");
            for (String message : userMessenger.receiveMessages("user1")) {
                System.out.println(message);
                log.info(message);
            }
        }
    }
}
