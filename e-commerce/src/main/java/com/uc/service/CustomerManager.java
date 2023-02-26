package com.uc.service;

import com.uc.model.Address;
import com.uc.model.Customer;
import com.uc.repo.BillRepository;
import com.uc.repo.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerManager {
    private static CustomerManager instance;
    private CustomerRepository customerRepository = CustomerRepository.getInstance();
    public static CustomerManager getInstance() {

        if (instance == null) {
            instance = new CustomerManager();
        }

        return instance;
    }
    public Customer save(String firstname,
                         String lastname,
                         String phone,
                         String email,
                         Address address) {
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setAddress(address);
        customer = customerRepository.save(customer);
        return customer;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
    public List<Customer> getCustomerFirstnameInCharacter(String character){
        return customerRepository.findAll().stream().filter((customer ->
            customer.getFirstname().contains(character))).collect(Collectors.toList());
    }
}
