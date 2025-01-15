package de.lessons.interfaces_lesson30.interface_problem;

public interface LoggerB {
    default void log(String message) {
        System.out.println("LoggerB: " + message);
    }
}
