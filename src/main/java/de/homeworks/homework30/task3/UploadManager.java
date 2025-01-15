package de.homeworks.homework30.task3;

public class UploadManager {
    public static void main(String[] args) {
        String photoPath1 = "somePhoto.png";
        String photoPath2 = "somePhoto.jpg";
        String videoPath1 = "someVideo.mp4";
        String videoPath2 = "someVideo.mov";
        String anyPath1 = "anyFile.zip";
        String anyPath2 = "anyFile.xml";

        PhotoUploader photoUploader = new PhotoUploader();
        VideoUploader videoUploader = new VideoUploader();

        photoUploader.uploadMedia(photoPath1);
        photoUploader.uploadMedia(photoPath2);
        videoUploader.uploadMedia(videoPath1);
        videoUploader.uploadMedia(videoPath2);

        System.out.println("File " + photoPath1 + " is photo: " + photoUploader.checkFileType(photoPath1));
        System.out.println("File " + photoPath2 + " is photo: " + photoUploader.checkFileType(photoPath2));
        System.out.println("File " + videoPath1 + " is video: " + videoUploader.checkFileType(videoPath1));
        System.out.println("File " + videoPath2 + " is video: " + videoUploader.checkFileType(videoPath2));

        System.out.println("File " + anyPath1 + " is photo: " + photoUploader.checkFileType(anyPath1));
        System.out.println("File " + anyPath2 + " is video: " + videoUploader.checkFileType(anyPath2));
    }
}
