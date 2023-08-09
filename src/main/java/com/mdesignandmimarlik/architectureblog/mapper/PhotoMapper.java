package com.mdesignandmimarlik.architectureblog.mapper;

import com.mdesignandmimarlik.architectureblog.database.entity.PhotoEntity;
import com.mdesignandmimarlik.architectureblog.model.PhotoDTO;
import org.springframework.stereotype.Component;

@Component
public class PhotoMapper {

    public PhotoDTO convertToDTO(PhotoEntity entity) {
        if (entity == null) {
            return null;
        }

        PhotoDTO dto = new PhotoDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSize(entity.getSize());
        dto.setFilePath(entity.getFilePath());
        dto.setUuid(entity.getUuid());
        return dto;
    }

    public PhotoEntity convertToEntity(PhotoDTO dto) {
        if (dto == null) {
            return null;
        }

        PhotoEntity entity = new PhotoEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSize(dto.getSize());
        entity.setFilePath(dto.getFilePath());
        entity.setUuid(dto.getUuid());
        return entity;
    }
}


