package com.uc.model;

import com.uc.model.base.BaseTimestamp;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Stock extends BaseTimestamp {
    private Product product;
    private Integer quantity;
}
