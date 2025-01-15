package de.lessons.interfaces_lesson30.interface_problem;

public class SocialLogger implements LoggerA, LoggerB {
    @Override
    public void log(String message) {
        LoggerA.super.log(message);
        LoggerB.super.log(message);
        System.out.println("SocialLogger: " + message);
    }

    public static void main(String[] args) {
        SocialLogger socialLogger = new SocialLogger();
        socialLogger.log("TestLog");
    }
}
