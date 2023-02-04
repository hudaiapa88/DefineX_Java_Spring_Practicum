package com.uc.model;

import com.uc.model.enums.HouseType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper = true)
public class Villa extends House{

    private Integer totalFloorNumber;
    public Villa() {
        setHouseType(HouseType.VILLA);
    }

    public House cast(){
        return (House) this;
    }
}
