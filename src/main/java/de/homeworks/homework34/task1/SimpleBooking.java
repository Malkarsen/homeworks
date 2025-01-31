package de.homeworks.homework34.task1;

public class SimpleBooking {
    public void bookRoom(int roomNumber, String guestName) throws IllegalArgumentException {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("The room number cannot be negative or zero.");
        }
        if (guestName == null || guestName.isEmpty()) {
            throw new IllegalArgumentException("The guest's name cannot be empty or null.");
        }
        System.out.println("Booking room " + roomNumber + " for " + guestName);
    }
}
