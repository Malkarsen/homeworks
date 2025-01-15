package de.homeworks.homework30.task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VideoUploader implements Uploadable {
    public VideoUploader(){}

    @Override
    public void uploadMedia(String filePath) {
        System.out.println("Video uploaded successfully (" + filePath + ")");
        log.info("Video uploaded successfully: {}", filePath);
    }

    @Override
    public boolean checkFileType(String filePath) {
        String fileType = filePath.substring(filePath.lastIndexOf('.') + 1).trim();
        return fileType.equalsIgnoreCase("mp4") || fileType.equalsIgnoreCase("mov");
    }
}
