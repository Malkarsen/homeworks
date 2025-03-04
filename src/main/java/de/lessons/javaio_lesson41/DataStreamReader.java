package de.lessons.javaio_lesson41;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class DataStreamReader {
    public static void main(String[] args) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.bin"))){
            int numberInt = dataInputStream.readInt();
            float numberFloat = dataInputStream.readFloat();
            String string = dataInputStream.readUTF();

            System.out.println(numberInt);
            System.out.println(numberFloat);
            System.out.println(string);
        } catch (IOException exception) {
            log.error("I/O error: {}", exception.getMessage());
        }
    }
}
