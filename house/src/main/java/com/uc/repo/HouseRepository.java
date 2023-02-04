package com.uc.repo;

import com.uc.model.Apartment;
import com.uc.model.House;
import com.uc.model.SummerHouse;
import com.uc.model.Villa;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class HouseRepository {

    private static List<Apartment> apartments;
    private static List<SummerHouse> summerHouses;
    private static List<Villa> villas;

    public static List<Apartment> getApartments() {
        return apartments;
    }

    public static void setApartments(List<Apartment> apartments) {
        HouseRepository.apartments = apartments;
    }

    public static List<SummerHouse> getSummerHouses() {
        return summerHouses;
    }

    public static void setSummerHouses(List<SummerHouse> summerHouses) {
        HouseRepository.summerHouses = summerHouses;
    }

    public static List<Villa> getVillas() {
        return villas;
    }

    public static void setVillas(List<Villa> villas) {
        HouseRepository.villas = villas;
    }

    public static List<House> getHouses(){
        List<House> houses=new ArrayList<>();
        houses.addAll(apartments.stream().map(Apartment::cast).collect(Collectors.toList()));
        houses.addAll(summerHouses.stream().map(SummerHouse::cast).collect(Collectors.toList()));
        houses.addAll(villas.stream().map(Villa::cast).collect(Collectors.toList()));
        return houses;
    }


}
