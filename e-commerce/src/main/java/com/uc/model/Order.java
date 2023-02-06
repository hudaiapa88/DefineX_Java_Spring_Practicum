package com.uc.model;

import com.uc.model.base.BaseTimestamp;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString(callSuper = true)
public class Order extends BaseTimestamp {
    private List<OrderLine> orderLines;
    private BigDecimal totalPrice;
    private Customer customer;
    private Address address;
}
