package de.homeworks.homework38;

import java.util.List;

public class YouTubeApp {
    public static void main(String[] args) {
        List<Video> videos = List.of(
                new Video("Как научиться программировать", "IT Channel",
                        1500000, 12000, 720, "Образование", true),
                new Video("Лучшие моменты матча", "Sports Channel",
                        500000, 8000, 600, "Спорт", false),
                new Video("Новый трек 2025", "Music Channel",
                        3000000, 25000, 240, "Музыка", true),
                new Video("Обзор новой игры", "Gaming Channel",
                        2000000, 15000, 900, "Игры", true),
                new Video("Как приготовить пиццу", "Cooking Channel",
                        800000, 10000, 1200, "Кулинария", false)
        );
        YouTubeAnalyzer youTubeAnalyzer = new YouTubeAnalyzer(videos);
        System.out.println("Video with more than 1M views: "
                + youTubeAnalyzer.getVideosWithMoreThan1MViews()); // 1
        System.out.println("Video titles that are longer than 10 minutes: "
                + youTubeAnalyzer.getTitlesOfLongVideos()); // 2
        System.out.println("All unique video categories: "
                + youTubeAnalyzer.getUniqueCategories());// 3
        System.out.println("List of video titles converted to uppercase: "
                + youTubeAnalyzer.getUppercaseTitles()); // 4
        System.out.println("List of objects containing only the video title and the number of likes: "
                + youTubeAnalyzer.getVideoInfosWithLikes()); // 5
        System.out.println("The 5 Most Viewed videos: "
                + youTubeAnalyzer.getSortedVideosByViewsDescending()); // 6
        System.out.println("The 3 shortest videos: "
                + youTubeAnalyzer.getSortedVideosByDurationAscending()); // 7
        System.out.println("The total number of videos: "
                + youTubeAnalyzer.getTotalVideoCount()); //8
        System.out.println("Video with the maximum number of likes: "
                + youTubeAnalyzer.getVideoWithMostLikes()); // 9
        System.out.println("Video with the minimum duration: "
                + youTubeAnalyzer.getVideoWithShortestDuration()); // 10
        System.out.println("There is at least one video with more than 10 million views: "
                + youTubeAnalyzer.hasVideoWithMoreThan1MViews()); // 11
        System.out.println("All videos in the \"Music\" category are monetized: "
                + youTubeAnalyzer.allMusicVideosMonetized()); // 12

        // ------Additional Tasks-----------
        System.out.println("Map where the key is the video category and the value is a list of videos in that category: "
                + youTubeAnalyzer.groupByVideoCategory()); // 13
        System.out.println("Average number of views for all videos: "
                + youTubeAnalyzer.getAverageViewCount()); // 14
        System.out.println("There is a video longer than 1 hour: "
                + youTubeAnalyzer.hasVideoWithMoreThan1HDuration()); // 15

    }
}
