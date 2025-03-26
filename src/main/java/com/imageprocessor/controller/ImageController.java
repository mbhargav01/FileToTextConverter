package com.imageprocessor.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imageprocessor.service.ImageProcessorService;

@RestController
@RequestMapping("/api/image")
public class ImageController {

	private final ImageProcessorService service;

    public ImageController(ImageProcessorService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String text = service.processImage(file.getInputStream());
            return ResponseEntity.ok(text);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to process image");
        }
    }
}
