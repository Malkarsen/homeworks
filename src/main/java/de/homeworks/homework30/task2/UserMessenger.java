package de.homeworks.homework30.task2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class UserMessenger implements Messenger {
    private Map<String, List<String>> messages;

    public UserMessenger() {
        this.messages = new HashMap<>();
    }

    @Override
    public void sendMessage(String message, String userId) {
        if (message == null || userId == null) {
            System.out.println("Message or user ID is null");
            log.info("Message or user ID is null");
        } else {
            if (messages.get(userId) == null) {
                messages.put(userId, new ArrayList<>());
            }
            System.out.println("Adding message: " + message + " to user: " + userId);
            messages.get(userId).add(message);
        }
    }

    @Override
    public List<String> receiveMessages(String userId) {
        if (messages.isEmpty() || !messages.containsKey(userId)) {
            System.out.println("No messages for user " + userId + " found");
            log.info("No messages for user {} found", userId);
            return null;
        } else {
            return new ArrayList<>(messages.get(userId).stream().toList());
        }
    }

    public HashMap<String, List<String>> getMessages() {
        return new HashMap<>(messages);
    }
}
