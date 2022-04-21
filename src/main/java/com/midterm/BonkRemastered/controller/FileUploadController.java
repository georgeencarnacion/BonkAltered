package com.midterm.BonkRemastered.controller;


import com.midterm.BonkRemastered.dto.BusinessDTO;
import com.midterm.BonkRemastered.services.BusinessService;
import com.midterm.BonkRemastered.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("upload")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/{id}/image")
    private ResponseEntity<Resource> getImage(@PathVariable Long id) throws IOException {
        BusinessDTO businessDTO = businessService.get(id);
        Resource resource = fileStorageService.load(businessDTO.getImageLocation());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .body(resource);
    }

}
