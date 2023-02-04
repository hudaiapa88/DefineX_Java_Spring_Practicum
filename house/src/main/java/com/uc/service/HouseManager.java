package com.uc.service;

import com.uc.model.House;
import com.uc.repo.HouseRepository;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class HouseManager {
    private static HouseManager instance;
    public static HouseManager getInstance(){

        if (instance == null){
            instance = new HouseManager();
        }

        return instance;
    }

    public BigDecimal getTotalPriceApartment(){
        return HouseRepository.getApartments().stream().map(House::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add );
    }
    public BigDecimal getTotalPriceVilla(){
        return HouseRepository.getVillas().stream().map(House::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add );
    }
    public BigDecimal getTotalPriceSummerHouse(){
        return HouseRepository.getSummerHouses().stream().map(House::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add );
    }
    public BigDecimal getTotalPriceHouse(){
        return HouseRepository.getHouses().stream().map(House::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add );
    }
    public Double getTotalSquareMetersApartment(){
        return HouseRepository.getApartments().stream().mapToDouble(House::getSquareMeter).sum()/HouseRepository.getApartments().size();
    }
    public Double getTotalSquareMetersVilla(){
        return HouseRepository.getVillas().stream().mapToDouble(House::getSquareMeter).sum()/HouseRepository.getApartments().size();
    }
    public Double getTotalSquareMetersSummerHouse(){
        return HouseRepository.getSummerHouses().stream().mapToDouble(House::getSquareMeter).sum()/HouseRepository.getApartments().size();
    }
    public Double getTotalSquareMetersHouse(){
        return HouseRepository.getHouses().stream().mapToDouble(House::getSquareMeter).sum()/HouseRepository.getApartments().size();
    }
    public List<House> getHouseFilter(String numberRooms){
        List<House> houses= HouseRepository.getHouses().stream().filter((house -> {
            return house.getNumberRooms().equals(numberRooms);
        })).collect(Collectors.toList());
        if (houses.isEmpty()){
             log.info("Bu oda ve salon sayısında uyuşaqn veri bulunamdı.");
        }
        return houses;
    }
}
