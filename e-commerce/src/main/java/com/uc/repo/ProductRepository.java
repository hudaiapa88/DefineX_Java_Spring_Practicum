package com.uc.repo;

import com.uc.model.Bill;
import com.uc.model.Order;
import com.uc.model.Product;
import com.uc.repo.base.BaseRepository;

import java.util.List;

public class ProductRepository implements BaseRepository<Product,Long> {

    private static List<Product> products;
    private static ProductRepository instance;

    public static ProductRepository getInstance(){

        if (instance == null){
            instance = new ProductRepository();
        }

        return instance;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Product save(Product value) {
        return null;
    }
}
