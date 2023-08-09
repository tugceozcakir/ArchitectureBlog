package com.mdesignandmimarlik.architectureblog.util;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseDTO {
    private Long id;
    private UUID uuid;
    private Date creationDate;
    private Date updatedDate;
}