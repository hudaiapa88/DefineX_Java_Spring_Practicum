package com.uc.service;

import com.uc.repo.BillRepository;

public class OrderManager {
    private static OrderManager instance;

    public static OrderManager getInstance(){

        if (instance == null){
            instance = new OrderManager();
        }

        return instance;
    }
}
