package de.homeworks.homework30.task3;

public interface Uploadable {
    void uploadMedia(String filePath);

    default boolean checkFileType(String filePath) {
        return !filePath.substring(filePath.lastIndexOf('.') + 1).trim().isEmpty();
    }
}
