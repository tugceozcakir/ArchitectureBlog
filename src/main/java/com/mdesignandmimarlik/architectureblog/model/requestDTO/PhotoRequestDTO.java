package com.mdesignandmimarlik.architectureblog.model.requestDTO;

import lombok.Data;

@Data
public class PhotoRequestDTO {
    private String name;
    private String filePath;
    private Long size;
}
