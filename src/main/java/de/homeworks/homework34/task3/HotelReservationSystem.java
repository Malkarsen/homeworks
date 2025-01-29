package de.homeworks.homework34.task3;

import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystem {
    Map<Integer, Boolean> rooms;

    public HotelReservationSystem() {
        this.rooms = new HashMap<>();
        rooms.put(101, false);
        rooms.put(102, false);
        rooms.put(103, false);
        rooms.put(201, false);
        rooms.put(202, false);
        rooms.put(203, false);
    }

    public void reserveRoom(int roomNumber, String guestName)
            throws IllegalArgumentException, RoomUnavailableException {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("The room number cannot be negative or zero.");
        }
        if (guestName == null || guestName.isEmpty()) {
            throw new IllegalArgumentException("The guest's name cannot be empty or null.");
        }
        if (!rooms.containsKey(roomNumber)) {
            throw new IllegalArgumentException("Room " + roomNumber + " is not on the list.");
        }
        if (rooms.get(roomNumber)) {
            throw new RoomUnavailableException("Room " + roomNumber + " is not available for booking.");
        }
        rooms.put(roomNumber, true);
        System.out.println("Room " + roomNumber + " for " + guestName + " reserved.");
    }

    public void cancelReservation(int roomNumber)
            throws IllegalArgumentException, NoActiveReservationException {
        if (!rooms.containsKey(roomNumber)) {
            throw new IllegalArgumentException("Room " + roomNumber + " is not on the list.");
        }
        if (!rooms.get(roomNumber)) {
            throw new NoActiveReservationException("You can't cancel a non-existent booking for room "
                    + roomNumber + ".");
        }
        rooms.put(roomNumber, false);
        System.out.println("Reservation for room " + roomNumber + " cancelled.");
    }
}
