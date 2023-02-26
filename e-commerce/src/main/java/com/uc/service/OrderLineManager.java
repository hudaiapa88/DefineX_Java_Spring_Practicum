package com.uc.service;

import com.uc.model.OrderLine;
import com.uc.model.Product;
import com.uc.repo.BillRepository;
import com.uc.repo.OrderLineRepository;
import com.uc.repo.OrderRepository;

import java.math.BigDecimal;

public class OrderLineManager {
    private static OrderLineManager instance;
   private OrderLineRepository orderLineRepository = OrderLineRepository.getInstance();
    public static OrderLineManager getInstance() {

        if (instance == null) {
            instance = new OrderLineManager();
        }
        return instance;
    }

    public OrderLine save(Product product,
                          Integer quantity,
                          BigDecimal totalPrice) {

        OrderLine orderLine= new OrderLine();
        orderLine.setQuantity(quantity);
        orderLine.setProduct(product);
        orderLine.setTotalPrice(totalPrice);
       return orderLineRepository.save(orderLine);
    }
}
