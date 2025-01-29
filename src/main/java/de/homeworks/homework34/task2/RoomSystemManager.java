package de.homeworks.homework34.task2;

import de.homeworks.homework34.task1.SimpleBooking;

import java.util.Arrays;
import java.util.HashMap;

public class RoomSystemManager {
    static RoomSystem roomSystem = new RoomSystem();

    public static void main(String[] args) {
        HashMap<Integer, String> roomMap = new HashMap<Integer, String>();
        roomMap.put(101, "Alice");
        roomMap.put(201, "");
        roomMap.put(0, "Charlie");
        roomMap.put(102, null);
        roomMap.put(103, "David");

        for (int roomNumber : roomMap.keySet()) {
            addGuest(roomNumber, roomMap.get(roomNumber));
            System.out.println("-------------");
            getGuest(roomNumber);
            System.out.println("-----------------------------");
        }
    }

    public static void addGuest(int roomIndex, String guestName) {
        try {
            roomSystem.addGuest(roomIndex, guestName);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Adding failed (Invalid room number): "
                    + exception.getMessage());
            System.out.println(Arrays.stream(exception.getStackTrace()).toList());
        } catch (IllegalArgumentException exception) {
            System.out.println("Adding failed (Invalid guest name): "
                    + exception.getMessage());
            System.out.println(Arrays.stream(exception.getStackTrace()).toList());
        }
    }

    public static void getGuest(int roomIndex) {
        try {
            roomSystem.getGuest(roomIndex);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Getting failed (Invalid room number): "
                    + exception.getMessage());
            System.out.println(Arrays.stream(exception.getStackTrace()).toList());
        } catch (NoGuestException exception) {
            System.out.println("Getting failed (There is no guest in the room): "
                    + exception.getMessage());
            System.out.println(Arrays.stream(exception.getStackTrace()).toList());
        }
    }
}
