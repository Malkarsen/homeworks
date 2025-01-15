package de.homeworks.homework30.task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhotoUploader implements Uploadable {
    public PhotoUploader() {}

    @Override
    public void uploadMedia(String filePath) {
        System.out.println("Photo uploaded successfully (" + filePath + ")");
        log.info("Photo uploaded successfully: {}", filePath);
    }

    @Override
    public boolean checkFileType(String filePath) {
        String fileType = filePath.substring(filePath.lastIndexOf('.') + 1).trim();
        return fileType.equalsIgnoreCase("jpg") || fileType.equalsIgnoreCase("png");
    }
}
