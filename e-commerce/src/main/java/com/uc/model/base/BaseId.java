package com.uc.model.base;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data

public class BaseId {
   private String id= UUID.randomUUID().toString();
}
