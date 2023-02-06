package com.uc.repo;

import com.uc.exception.NotFoundException;
import com.uc.model.Bill;
import com.uc.model.Order;
import com.uc.model.OrderLine;
import com.uc.repo.base.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements BaseRepository<Order,String> {

    private static List<Order> orders= new ArrayList<>();;
    private static OrderRepository instance;

    public static OrderRepository getInstance(){

        if (instance == null){
            instance = new OrderRepository();
        }

        return instance;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public Order findById(String id) {
        return orders.stream().filter((value)->value.getId().equals(id)).findAny().orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        orders.removeIf((value)->value.getId().equals(id));
    }

    @Override
    public Order save(Order value) {
        return orders.add(value) ? value : null;
    }
}
