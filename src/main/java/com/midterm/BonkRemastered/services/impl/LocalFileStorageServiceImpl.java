package com.midterm.BonkRemastered.services.impl;


import com.midterm.BonkRemastered.services.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LocalFileStorageServiceImpl implements FileStorageService {

    private final Path uploads = Paths.get("uploads");

    @Override
    public void save(MultipartFile file) {
        init();
        try {
            Files.copy(file.getInputStream(), this.uploads.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init() {
        try {
            if (!Files.exists(uploads)) {
                Files.createDirectory(uploads);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public Resource load(String filename) {
       Path filePath = uploads.resolve((filename));

       try {
           Resource resource = new UrlResource(filePath.toUri());
           return resource;

       } catch (MalformedURLException e) {
           e.printStackTrace();
       }
       return null;
    }
}
