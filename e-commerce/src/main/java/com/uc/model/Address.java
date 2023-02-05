package com.uc.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {
    private String country;
    private String province;
    private String district;
    private String neighbourhood;
    private String fullAddress;
}
