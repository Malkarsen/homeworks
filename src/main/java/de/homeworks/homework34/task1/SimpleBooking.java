package de.homeworks.homework34.task1;

import de.lessons.excepionshandling_lesson34.Calculator;

import java.util.Arrays;
import java.util.HashMap;

public class SimpleBooking {
    public static void bookRoom(int roomNumber, String guestName) throws IllegalArgumentException {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("The room number cannot be negative or zero.");
        }
        if (guestName == null || guestName.isEmpty()) {
            throw new IllegalArgumentException("The guest's name cannot be empty or null.");
        }
        System.out.println("Booking room " + roomNumber + " for " + guestName);
    }
}
