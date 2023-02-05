package com.uc.repo;

import com.uc.model.Bill;
import com.uc.model.Customer;
import com.uc.model.OrderLine;
import com.uc.repo.base.BaseRepository;

import java.util.List;

public class OrderLineRepository implements BaseRepository<OrderLine,Long> {
    private static List<OrderLine> orderLines;
    private static OrderLineRepository instance;

    public static OrderLineRepository getInstance(){

        if (instance == null){
            instance = new OrderLineRepository();
        }

        return instance;
    }

    @Override
    public List<OrderLine> findAll() {
        return null;
    }

    @Override
    public OrderLine findById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public OrderLine save(OrderLine value) {
        return null;
    }
}
