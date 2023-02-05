package com.uc.repo;

import com.uc.model.Bill;
import com.uc.model.Product;
import com.uc.model.Stock;
import com.uc.repo.base.BaseRepository;

import java.util.List;

public class StockRepository implements BaseRepository<Stock,Long> {

    private static List<Stock> stocks;
    private static StockRepository instance;

    public static StockRepository getInstance(){

        if (instance == null){
            instance = new StockRepository();
        }

        return instance;
    }

    @Override
    public List<Stock> findAll() {
        return null;
    }

    @Override
    public Stock findById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Stock save(Stock value) {
        return null;
    }
}
