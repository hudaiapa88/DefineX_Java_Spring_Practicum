package com.uc.service;

import com.uc.repo.BillRepository;

public class OrderLineManager {
    private static OrderLineManager instance;

    public static OrderLineManager getInstance(){

        if (instance == null){
            instance = new OrderLineManager();
        }

        return instance;
    }
}
