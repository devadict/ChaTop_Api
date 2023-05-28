package com.app.raghu.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.nio.file.*;

@Service
public class UploadPhoto {
    public static String uploadPicture(MultipartFile picture) throws IOException {
        String fileName = StringUtils.cleanPath(picture.getOriginalFilename());

        Path tempDir = Files.createTempDirectory(Paths.get("src"), "picture");
        Path filePath = tempDir.resolve(fileName);

        try (OutputStream os = Files.newOutputStream(filePath)) {
            os.write(picture.getBytes());
        }

        String newPic = filePath.toString();

        return newPic;
    }
}