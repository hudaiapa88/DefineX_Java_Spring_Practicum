package com.uc.service;

import com.uc.repo.BillRepository;

public class BillManager {

    private static BillManager instance;

    public static BillManager getInstance(){

        if (instance == null){
            instance = new BillManager();
        }

        return instance;
    }
}
