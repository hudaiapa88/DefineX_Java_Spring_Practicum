package com.uc.model;

import com.uc.model.base.BaseId;
import com.uc.model.base.BaseTimestamp;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString(callSuper = true)
public class Bill extends BaseId {
    private LocalDateTime billDate;
    private Order order;
}
