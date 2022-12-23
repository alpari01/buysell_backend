package ee.taltech.iti0302.controller;

import ee.taltech.iti0302.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/api/public/images/{imageId}")
    public ResponseEntity<Object> getImageById(@PathVariable("imageId") Integer imageId) {
        return imageService.getImageById(imageId);
    }

    @PostMapping("/api/public/images")
    public void saveImage(@RequestParam("file") MultipartFile file) throws IOException {
        imageService.saveImage(file);
    }
}
