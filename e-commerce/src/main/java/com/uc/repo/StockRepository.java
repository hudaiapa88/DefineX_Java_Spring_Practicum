package com.uc.repo;

import com.uc.exception.NotFoundException;
import com.uc.model.Bill;
import com.uc.model.Product;
import com.uc.model.Stock;
import com.uc.repo.base.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class StockRepository implements BaseRepository<Stock,String> {

    private static List<Stock> stocks = new ArrayList<>();;
    private static StockRepository instance;

    public static StockRepository getInstance(){

        if (instance == null){
            instance = new StockRepository();
        }

        return instance;
    }

    @Override
    public List<Stock> findAll() {
        return stocks;
    }

    @Override
    public Stock findById(String id) {
        return stocks.stream().filter((value)->value.getId().equals(id)).findAny().orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        stocks.removeIf((value)->value.getId().equals(id));
    }

    @Override
    public Stock save(Stock value) {
        return stocks.add(value) ? value : null;
    }
}
