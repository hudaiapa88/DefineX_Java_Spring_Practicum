package com.uc.repo;

import com.uc.exception.NotFoundException;
import com.uc.model.Bill;
import com.uc.model.Customer;
import com.uc.repo.base.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements BaseRepository<Customer,String> {
    private static List<Customer> customers= new ArrayList<>();
    private static CustomerRepository instance;

    public static CustomerRepository getInstance(){

        if (instance == null){
            instance = new CustomerRepository();
        }

        return instance;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String id) {
        return customers.stream().filter((value)->value.getId().equals(id)).findAny().orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        customers.removeIf((value)->value.getId().equals(id));
    }

    @Override
    public Customer save(Customer value) {
        return customers.add(value) ? value : null;
    }
}
