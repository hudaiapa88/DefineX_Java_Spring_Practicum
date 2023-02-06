package com.uc.model.base;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
public class BaseTimestamp extends BaseId{
    private LocalDateTime createdDateTime = LocalDateTime.now();
}
