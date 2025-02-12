package de.homeworks.homework38;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class YouTubeAnalyzer {
    private List<Video> videos;

    public YouTubeAnalyzer(List<Video> videos) {
        this.videos = videos;
    }

    // 1 Фильтрация и сбор данных
    // 1. Отфильтруйте видео, которые имеют более 1 миллиона просмотров, и соберите их в список
    // Подсказка: Используйте filter для отбора видео и collect для сбора в список.
    public List<Video> getVideosWithMoreThan1MViews() {
        return videos.stream()
                .filter(video -> video.getViews() > 1000000)
                .collect(Collectors.toList());
    }

    // 2. Создайте список названий видео, которые длятся более 10 минут.
    // Подсказка: Преобразуйте длительность из секунд в минуты (1 минута = 60 секунд). Используйте map для получения названий.
    public List<String> getTitlesOfLongVideos() {
        return videos.stream()
                .filter(video -> video.getDuration() > 10 * 60)
                .map(Video::getTitle)
                .collect(Collectors.toList());
    }

    // 3. Найдите все уникальные категории видео.
    // Подсказка: Используйте map для получения категорий и distinct для удаления дубликатов.
    public List<String> getUniqueCategories() {
        return videos.stream()
                .map(Video::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }

    // 2 Преобразование данных
    // 4. Создайте список названий видео, преобразовав их в верхний регистр.
    // Подсказка: Используйте map для преобразования строк в верхний регистр.
    public List<String> getUppercaseTitles() {
        return  videos.stream()
                .map(video -> video.getTitle().toUpperCase())
                .collect(Collectors.toList());
    }

    // 5. Создайте список объектов, содержащих только название видео и количество лайков.
    // Подсказка: Создайте новый класс или используйте Map.Entry для хранения пар "название-лайки".
    public Map<String, Integer> getVideoInfosWithLikes() {
        return videos.stream()
                .collect(Collectors.toMap(Video::getTitle, Video::getLikes));
    }

    // 3. Сортировка и ограничение
    // 6. Отсортируйте видео по количеству просмотров в порядке убывания и выведите первые 5.
    // Подсказка: Используйте sorted с компаратором и limit для ограничения количества элементов.
    public List<Video> getSortedVideosByViewsDescending() {
        return  videos.stream()
                .sorted(Comparator.comparingInt(Video::getViews).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    // 7. Отсортируйте видео по длительности в порядке возрастания и выведите первые 3.
    // Подсказка: Аналогично предыдущему заданию, но сортируйте по длительности.
    public List<Video> getSortedVideosByDurationAscending() {
        return videos.stream()
                .sorted(Comparator.comparingInt(Video::getDuration))
                .limit(3)
                .collect(Collectors.toList());
    }

    // 4. Агрегация данных
    // 8. Посчитайте общее количество видео в списке.
    // Подсказка: Используйте метод count.
    public long getTotalVideoCount() {
        return videos.stream()
                .count();
    }
    // 9. Найдите видео с максимальным количеством лайков.
    // Подсказка: Используйте max с компаратором по количеству лайков.
    public Optional<Video> getVideoWithMostLikes() {
        return videos.stream()
                .max(Comparator.comparingInt(Video::getLikes));
    }

    // 10. Найдите видео с минимальной длительностью.
    // Подсказка: Используйте min с компаратором по длительности.
    public Optional<Video> getVideoWithShortestDuration() {
        return videos.stream()
                .min(Comparator.comparingInt(Video::getDuration));
    }

    // 5. Проверка условий
    // 11.Проверьте, есть ли хотя бы одно видео с количеством просмотров более 10 миллионов.
    // Подсказка: Используйте anyMatch с условием на количество просмотров.
    public boolean hasVideoWithMoreThan1MViews() {
        return videos.stream()
                .anyMatch(video -> video.getViews() > 10000000);
    }

    // 12. Проверьте, все ли видео в категории "Музыка" монетизированы.
    // Подсказка: Используйте filter для отбора видео категории "Музыка" и allMatch для проверки монетизации.
    public boolean allMusicVideosMonetized() {
        return videos.stream()
                .filter(video -> video.getCategory().equals("Музыка"))
                .allMatch(Video::isMonetized);
    }

    // Дополнительные задания (по желанию)
    // 1. Создайте Map, где ключом будет категория видео, а значением — список видео в этой категории.
    // Подсказка: Используйте Collectors.groupingBy.
    public Map<String, List<Video>> groupByVideoCategory() {
        return videos.stream()
                .collect(Collectors.groupingBy(Video::getCategory));
    }

    // 2. Найдите среднее количество просмотров для всех видео.
    // Подсказка: Используйте Collectors.averagingInt.
    public double getAverageViewCount() {
        return videos.stream()
                .collect(Collectors.averagingInt(Video::getViews));
    }

    // 3. Проверьте, есть ли видео, которое длится более 1 часа.
    // Подсказка: Используйте anyMatch с условием на длительность (1 час = 3600 секунд).
    public boolean hasVideoWithMoreThan1HDuration() {
        return  videos.stream()
                .anyMatch(video -> video.getDuration() > 3600);
    }

}
