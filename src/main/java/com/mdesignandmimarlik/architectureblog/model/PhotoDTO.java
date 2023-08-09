package com.mdesignandmimarlik.architectureblog.model;

import com.mdesignandmimarlik.architectureblog.util.BaseDTO;
import lombok.Data;

@Data
public class PhotoDTO extends BaseDTO {
    private String name;
    private String filePath;
    private Long size;

}


