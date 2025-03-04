package de.lessons.javaio_lesson41;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class DataStreamWriter {
    public static void main(String[] args) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.bin"))) {
            dataOutputStream.writeInt(123);
            dataOutputStream.writeFloat(3.14f);
            dataOutputStream.writeUTF("Hello, World!");
        } catch (FileNotFoundException exception) {
            log.error("File not found: {}", exception.getMessage());
        } catch (IOException exception) {
            log.error("I/O error: {}", exception.getMessage());
        }
    }
}
