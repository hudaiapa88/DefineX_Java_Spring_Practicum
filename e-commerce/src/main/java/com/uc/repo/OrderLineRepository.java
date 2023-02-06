package com.uc.repo;

import com.uc.exception.NotFoundException;
import com.uc.model.Bill;
import com.uc.model.Customer;
import com.uc.model.OrderLine;
import com.uc.repo.base.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderLineRepository implements BaseRepository<OrderLine,String> {
    private static List<OrderLine> orderLines= new ArrayList<>();;
    private static OrderLineRepository instance;

    public static OrderLineRepository getInstance(){

        if (instance == null){
            instance = new OrderLineRepository();
        }

        return instance;
    }

    @Override
    public List<OrderLine> findAll() {
        return orderLines;
    }

    @Override
    public OrderLine findById(String id) {
        return orderLines.stream().filter((value)->value.getId().equals(id)).findAny().orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        orderLines.removeIf((value)->value.getId().equals(id));
    }

    @Override
    public OrderLine save(OrderLine value) {
        return orderLines.add(value) ? value : null;
    }
}
