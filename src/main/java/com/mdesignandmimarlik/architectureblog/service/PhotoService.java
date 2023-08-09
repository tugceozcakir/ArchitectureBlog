package com.mdesignandmimarlik.architectureblog.service;

import com.mdesignandmimarlik.architectureblog.database.entity.PhotoEntity;
import com.mdesignandmimarlik.architectureblog.database.repository.PhotoRepository;
import com.mdesignandmimarlik.architectureblog.mapper.PhotoMapper;
import com.mdesignandmimarlik.architectureblog.model.PhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

    @Autowired
    public PhotoService(PhotoRepository photoRepository, PhotoMapper photoMapper) {
        this.photoRepository = photoRepository;
        this.photoMapper = photoMapper;
    }

    public PhotoDTO uploadPhoto(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Boş dosya yüklenemez.");
        }

        String uploadDir = "/Users/tugceozcakir/Desktop/testUpload";
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String uniqueFilename = UUID.randomUUID() + "_" + originalFilename;

        try {
            if (originalFilename.contains("..")) {
                throw new IllegalArgumentException("Dosya yolu geçersiz: " + originalFilename);
            }

            Files.createDirectories(Paths.get(uploadDir));
            Path filePath = Paths.get(uploadDir, uniqueFilename);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            PhotoEntity photo = new PhotoEntity();
            photo.setName(originalFilename);
            photo.setSize(file.getSize());
            photo.setFilePath(filePath.toString());

            return photoMapper.convertToDTO(photoRepository.save(photo));
        } catch (IOException e) {
            throw new IOException("Dosya kaydedilirken hata oluştu: " + e.getMessage());
        }
    }

    public PhotoDTO getPhotoById(Long id) {
        PhotoEntity photoEntity = photoRepository.findById(id).orElse(null);
        return photoMapper.convertToDTO(photoEntity);
    }
}
