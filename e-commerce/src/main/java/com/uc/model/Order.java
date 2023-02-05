package com.uc.model;

import com.uc.model.base.BaseTimestamp;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class Order extends BaseTimestamp {
    private List<OrderLine> orderLines;
    private BigDecimal totalPrice;
    private Address address;
}
