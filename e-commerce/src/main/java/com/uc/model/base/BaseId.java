package com.uc.model.base;

import lombok.Data;

import java.util.UUID;

@Data
public class BaseId {
    String id= UUID.randomUUID().toString();
}
