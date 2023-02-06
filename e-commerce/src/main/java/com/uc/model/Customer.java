package com.uc.model;

import com.uc.model.base.BaseTimestamp;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Customer extends BaseTimestamp {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Address address;
}
