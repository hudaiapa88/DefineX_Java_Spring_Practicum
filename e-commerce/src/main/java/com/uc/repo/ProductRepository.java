package com.uc.repo;

import com.uc.exception.NotFoundException;
import com.uc.model.Bill;
import com.uc.model.Order;
import com.uc.model.Product;
import com.uc.repo.base.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements BaseRepository<Product,String > {

    private static List<Product> products= new ArrayList<>();;
    private static ProductRepository instance;

    public static ProductRepository getInstance(){

        if (instance == null){
            instance = new ProductRepository();
        }

        return instance;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(String id) {
        return products.stream().filter((value)->value.getId().equals(id)).findAny().orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        products.removeIf((value)->value.getId().equals(id));
    }

    @Override
    public Product save(Product value) {
        return products.add(value) ? value : null;
    }
}
