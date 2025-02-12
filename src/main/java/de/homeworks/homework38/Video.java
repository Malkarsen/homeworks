package de.homeworks.homework38;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Video {
    private String title;         // Название видео
    private String channel;       // Название канала
    private int views;            // Количество просмотров
    private int likes;            // Количество лайков
    private int duration;         // Длительность видео в секундах
    private String category;      // Категория видео (например, "Музыка", "Образование", "Игры")
    private boolean isMonetized;  // Монетизировано ли видео
}
