package de.lessons.interfaces_lesson30.interface_problem;

public interface LoggerA {
    default void log(String message) {
        System.out.println("LoggerA: " + message);
    }
}
