package de.homeworks.homework34.task2;

public class RoomSystem {
    private int[] rooms = {101, 102, 103, 201, 202};
    private String[] guests = new String[5];

    public void addGuest(int roomIndex, String guestName) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (!isRoomIndexInMassive(roomIndex)) {
            throw new ArrayIndexOutOfBoundsException("Room " + roomIndex + " is not on the list.");
        }
        if (guestName == null || guestName.isEmpty()) {
            throw new IllegalArgumentException("The guest's name cannot be empty or null.");
        }
        int guestIndex = getIndexOfRoom(roomIndex);
        guests[guestIndex] = guestName;
        System.out.println("Guest " + guestName + " has been added to room " + roomIndex);
    }

    public String getGuest(int roomIndex) throws ArrayIndexOutOfBoundsException, NoGuestException {
        if (!isRoomIndexInMassive(roomIndex)) {
            throw new ArrayIndexOutOfBoundsException("Room " + roomIndex + " is not on the list.");
        }
        int guestIndex = getIndexOfRoom(roomIndex);
        if (guests[guestIndex] == null) {
            throw new NoGuestException("There is no guest in room " + roomIndex);
        }
        String guestName = guests[guestIndex];
        System.out.println("Guest in room " + roomIndex + ": " + guestName);
        return guestName;
    }

    public boolean isRoomIndexInMassive(int roomIndex) {
        for (int room : rooms) {
            if (room == roomIndex) {
                return true;
            }
        }
        return false;
    }

    private int getIndexOfRoom(int roomIndex) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == roomIndex) {
                return i;
            }
        }
        return -1;
    }
}
