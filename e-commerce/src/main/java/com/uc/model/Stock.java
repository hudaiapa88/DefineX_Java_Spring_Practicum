package com.uc.model;

import com.uc.model.base.BaseTimestamp;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Stock extends BaseTimestamp {
    private Product product;
    private Integer quantity;
}
