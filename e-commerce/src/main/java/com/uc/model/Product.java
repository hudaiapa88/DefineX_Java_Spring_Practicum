package com.uc.model;

import com.uc.model.base.BaseId;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product extends BaseId {
    String title;
    String price;
}
