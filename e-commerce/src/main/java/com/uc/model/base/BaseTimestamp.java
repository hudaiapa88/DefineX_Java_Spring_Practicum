package com.uc.model.base;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseTimestamp extends BaseId{
    private LocalDateTime createdDateTime = LocalDateTime.now();
}
