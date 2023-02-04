package com.uc.model;

import com.uc.model.enums.HouseType;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class SummerHouse extends House{
    private Integer floorLocation;
    public SummerHouse() {
        setHouseType(HouseType.SUMMERHOUSE);
    }

    public House cast(){
        return (House) this;
    }
}
