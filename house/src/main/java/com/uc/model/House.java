package com.uc.model;

import com.uc.model.base.Base;
import com.uc.model.enums.HouseType;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString(callSuper = true)
public class House extends Base {
  private String title;
  private BigDecimal price;
  private LocalDate advertisementDate;
  private String numberRooms;
  private Double squareMeter;
  private HouseType houseType;
}
