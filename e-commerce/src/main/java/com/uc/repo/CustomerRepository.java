package com.uc.repo;

import com.uc.model.Bill;
import com.uc.model.Customer;
import com.uc.repo.base.BaseRepository;

import java.util.List;

public class CustomerRepository implements BaseRepository<Customer,Long> {
    private static List<Customer> customers;
    private static CustomerRepository instance;

    public static CustomerRepository getInstance(){

        if (instance == null){
            instance = new CustomerRepository();
        }

        return instance;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Customer save(Customer value) {
        return null;
    }
}
