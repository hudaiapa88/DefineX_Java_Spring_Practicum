package com.uc.repo;

import com.uc.exception.NotFoundException;
import com.uc.model.Bill;
import com.uc.repo.base.BaseRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class BillRepository implements BaseRepository<Bill,Long> {

    private static List<Bill> bills;
    private static BillRepository instance;

    public static BillRepository getInstance(){

        if (instance == null){
            instance = new BillRepository();
        }

        return instance;
    }

    @Override
    public List<Bill> findAll() {
        return bills;
    }

    @Override
    public Bill findById(Long id) {
        return bills.stream().filter((bill)->bill.getId().equals(id)).findAny().orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Bill save(Bill value) {
        return null;
    }
}
