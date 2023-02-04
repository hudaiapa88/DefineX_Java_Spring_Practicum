package com.uc;

import com.uc.repo.RepoLoader;
import com.uc.service.HouseManager;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Main {
    public static void main(String[] args) {

        String randomNumberRooms=(new Random().nextInt(7)+1)+"+1";

        RepoLoader repoLoader= new RepoLoader();
        log.info("Datalar yüklendi");
        HouseManager houseManager= HouseManager.getInstance();
        log.info("HouseManager instance'ı ayağa kalktı.");
        log.info("");
        log.info("Evlerin toplam fiyatı : "+houseManager.getTotalPriceApartment()+" TL");
        log.info("");
        log.info("Villaların toplam fiyatı : "+houseManager.getTotalPriceVilla()+" TL");
        log.info("");
        log.info("Yazlıkların toplam fiyatı : "+houseManager.getTotalPriceSummerHouse()+" TL");
        log.info("");
        log.info("Tüm tipteki evlerin toplam fiyatı : "+houseManager.getTotalPriceHouse()+" TL");
        log.info("");
        log.info("Villaların ortalama metrekaresi : "+houseManager.getTotalSquareMetersApartment());
        log.info("");
        log.info("Villaların ortalama metrekaresi : "+houseManager.getTotalSquareMetersVilla());
        log.info("");
        log.info("Yazlıkların ortalama metrekaresi : "+houseManager.getTotalSquareMetersSummerHouse());
        log.info("");
        log.info("Tüm tipteki evlerin ortalama metrekaresi : "+houseManager.getTotalSquareMetersHouse());
        log.info("");
        log.info("Tüm tipteki evlerin ortalama metrekaresi : "+houseManager.getTotalSquareMetersHouse());
        log.info("");
        log.info("Oda ve Salon filtresi : "+randomNumberRooms );
        log.info(randomNumberRooms + " Olan tüm tipteki evler");
        houseManager.getHouseFilter(randomNumberRooms).stream().forEach((house)->{
            log.info(house.toString());
        });


    }
}