package com.uc.service;

import com.uc.repo.BillRepository;

public class ProductManager {
    private static ProductManager instance;

    public static ProductManager getInstance(){

        if (instance == null){
            instance = new ProductManager();
        }

        return instance;
    }
}
