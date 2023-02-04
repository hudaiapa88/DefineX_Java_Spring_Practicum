package com.uc.model;

import com.uc.model.enums.HouseType;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Apartment extends House{
    private Integer floorLocation;
    public Apartment() {
        setHouseType(HouseType.APARTMENT);
    }

    public House cast(){
        return (House) this;
    }
}
