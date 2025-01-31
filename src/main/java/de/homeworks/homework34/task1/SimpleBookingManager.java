package de.homeworks.homework34.task1;

import java.util.Arrays;
import java.util.HashMap;

public class SimpleBookingManager {
    public static void main(String[] args) {
        SimpleBooking simpleBooking = new SimpleBooking();
        HashMap<Integer, String> roomMap = new HashMap<Integer, String>();
        roomMap.put(-1, "Alice");
        roomMap.put(2, "");
        roomMap.put(0, "Charlie");
        roomMap.put(4, null);
        roomMap.put(5, "David");

        for (int roomNumber : roomMap.keySet()) {
            try {
                simpleBooking.bookRoom(roomNumber, roomMap.get(roomNumber));
            } catch (IllegalArgumentException exception) {
                System.out.println("Incorrect booking information: "
                        + exception.getMessage());
                System.out.println(Arrays.stream(exception.getStackTrace()).toList());
            }
        }
    }
}
