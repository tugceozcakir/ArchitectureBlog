package com.mdesignandmimarlik.architectureblog.database.entity;

import com.mdesignandmimarlik.architectureblog.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "photos")
@Data
public class PhotoEntity extends BaseEntity {
    private Long id;
    private String name;
    private String filePath;
    private Long size;
    private int orderNo;
}
