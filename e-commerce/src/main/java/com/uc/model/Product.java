package com.uc.model;

import com.uc.model.base.BaseId;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString(callSuper = true)
public class Product extends BaseId {
    String title;
    BigDecimal price;
}
