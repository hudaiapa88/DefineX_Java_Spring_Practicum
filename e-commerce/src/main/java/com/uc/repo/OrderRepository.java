package com.uc.repo;

import com.uc.model.Bill;
import com.uc.model.Order;
import com.uc.model.OrderLine;
import com.uc.repo.base.BaseRepository;

import java.util.List;

public class OrderRepository implements BaseRepository<Order,Long> {

    private static List<Order> orders;
    private static OrderRepository instance;

    public static OrderRepository getInstance(){

        if (instance == null){
            instance = new OrderRepository();
        }

        return instance;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order findById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Order save(Order value) {
        return null;
    }
}
