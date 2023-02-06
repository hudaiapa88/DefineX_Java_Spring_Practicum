package com.uc.service;

import com.uc.repo.BillRepository;

public class CustomerManager {
    private static CustomerManager instance;

    public static CustomerManager getInstance(){

        if (instance == null){
            instance = new CustomerManager();
        }

        return instance;
    }
}
