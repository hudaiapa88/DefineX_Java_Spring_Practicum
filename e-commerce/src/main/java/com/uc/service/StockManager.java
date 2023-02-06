package com.uc.service;

import com.uc.repo.BillRepository;

public class StockManager {
    private static StockManager instance;

    public static StockManager getInstance(){

        if (instance == null){
            instance = new StockManager();
        }

        return instance;
    }
}
