package com.uc.repo;

import com.uc.model.Apartment;
import com.uc.model.House;
import com.uc.model.SummerHouse;
import com.uc.model.Villa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class RepoLoader {
    public RepoLoader() {
        apartmentLoader();
        summerHouseLoader();
        villaLoader();
    }

    private static List<String> values= Arrays.asList("Denizli içi ","Acıpayam içi ","Baklan da","Buldanda","Antalyada");
    public void apartmentLoader(){
        List<Apartment> apartments=new ArrayList<>();
        for(int i=0;i<10;i++){
            Apartment apartment= new Apartment();
            Integer roomNumber= new Random().nextInt(5)+1;
            apartment.setId(UUID.randomUUID().getLeastSignificantBits());
            apartment.setTitle(values.get(new Random().nextInt(values.size())) +" Satılık daire "+roomNumber+"1");
            apartment.setPrice(new BigDecimal(new Random().nextInt(500000)+200000));
            apartment.setAdvertisementDate(LocalDate.now().minusMonths(new Random().nextInt(4)+1));
            apartment.setNumberRooms(roomNumber+"+1");
            apartment.setFloorLocation(new Random().nextInt(7)+1);
            apartment.setSquareMeter( new Random().nextInt(150)+60D);
            apartments.add(apartment);
        }
        HouseRepository.setApartments(apartments);
    }
    public void summerHouseLoader(){
        List<SummerHouse> summerHouses=new ArrayList<>();
        for(int i=0;i<10;i++){
            SummerHouse summerHouse= new SummerHouse();
            Integer roomNumber= new Random().nextInt(5)+1;
            summerHouse.setId(UUID.randomUUID().getLeastSignificantBits());
            summerHouse.setTitle(values.get(new Random().nextInt(values.size())) +" Satılık yazlık "+roomNumber+"1");
            summerHouse.setPrice(new BigDecimal(new Random().nextInt(1000000)+500000));
            summerHouse.setAdvertisementDate(LocalDate.now().minusMonths(new Random().nextInt(4)+1));
            summerHouse.setNumberRooms(roomNumber+"+1");
            summerHouse.setFloorLocation(new Random().nextInt(7)+1);
            summerHouse.setSquareMeter(new Random().nextInt(150)+60D);
            summerHouses.add(summerHouse);
        }
        HouseRepository.setSummerHouses(summerHouses);
    }
    public void villaLoader(){
        List<Villa> villas=new ArrayList<>();
        for(int i=0;i<10;i++){
            Villa villa= new Villa();
            Integer roomNumber= new Random().nextInt(7)+1;
            villa.setId(UUID.randomUUID().getLeastSignificantBits());
            villa.setTitle(values.get(new Random().nextInt(values.size())) +" Satılık villa "+roomNumber+"1");
            villa.setPrice(new BigDecimal(new Random().nextInt(1000000)+500000));
            villa.setTotalFloorNumber(new Random().nextInt(3)+1);
            villa.setAdvertisementDate(LocalDate.now().minusMonths(new Random().nextInt(4)+1));
            villa.setNumberRooms(roomNumber+"+1");
            villa.setSquareMeter(new Random().nextInt(150)+60D);
            villas.add(villa);
        }

        HouseRepository.setVillas(villas);
    }

}
