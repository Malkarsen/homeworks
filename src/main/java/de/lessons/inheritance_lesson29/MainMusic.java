package de.lessons.inheritance_lesson29;

public class MainMusic {
    public static void main(String[] args) {
        PopTrack popTrack = new PopTrack("Pop-dance-hits", "DJ Khaled", 10);
        popTrack.printInfo();
        popTrack.play();

        System.out.println("--------------------------------");
        RockTrack rockTrack = new RockTrack("Rock-Dance-hits", "DJ Gurat", 100);
        rockTrack.printInfo();
        rockTrack.play();
    }
}
