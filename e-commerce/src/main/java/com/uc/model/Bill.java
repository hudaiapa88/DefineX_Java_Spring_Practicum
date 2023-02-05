package com.uc.model;

import com.uc.model.base.BaseId;
import com.uc.model.base.BaseTimestamp;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
public class Bill extends BaseId {
    private LocalDateTime billDate;
    private Customer customer;
    private Order order;
}
