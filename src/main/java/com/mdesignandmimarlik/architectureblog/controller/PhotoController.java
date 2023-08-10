package com.mdesignandmimarlik.architectureblog.controller;

import com.mdesignandmimarlik.architectureblog.database.entity.PhotoEntity;
import com.mdesignandmimarlik.architectureblog.model.PhotoDTO;
import com.mdesignandmimarlik.architectureblog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPhoto(@RequestParam("file") MultipartFile file) {
        try {
            PhotoDTO uploadedPhotoDTO = photoService.uploadPhoto(file);
            return ResponseEntity.ok(uploadedPhotoDTO);
        } catch (IOException e) {
            String errorMessage = "Dosya yükleme sırasında bir hata oluştu: " + e.getLocalizedMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoDTO> getPhotoById(@PathVariable Long id) {
        PhotoDTO photoDTO = photoService.getPhotoById(id);
        if (photoDTO != null) {
            return ResponseEntity.ok(photoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePhotoById(@PathVariable Long id){
        boolean deleted = photoService.deletePhotoById(id);
        if(deleted)
            return ResponseEntity.ok("Photo deleted succesfully");
        else
            return ResponseEntity.notFound().build();
    }

}
