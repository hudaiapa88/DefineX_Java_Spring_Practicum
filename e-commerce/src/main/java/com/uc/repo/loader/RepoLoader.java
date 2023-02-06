package com.uc.repo.loader;

import com.uc.model.*;
import com.uc.repo.*;
import com.uc.service.ProductManager;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class RepoLoader {
    BillRepository billRepository = BillRepository.getInstance();
    CustomerRepository customerRepository = CustomerRepository.getInstance();
    OrderLineRepository orderLineRepository = OrderLineRepository.getInstance();
    OrderRepository orderRepository = OrderRepository.getInstance();
    ProductRepository productRepository = ProductRepository.getInstance();
    StockRepository stockRepository = StockRepository.getInstance();

    public RepoLoader() {
        log.info("-----------------Demo veriler yükleniyor--------------");
       customerLoader();
       productLoader();
       stockLoader();
       orderLoader();
       billLoader();

    }

    private void billLoader() {
        Bill bill= new Bill();
        bill.setBillDate(LocalDateTime.now());
        bill.setOrder(orderRepository.findAll().stream().findFirst().get());
        billRepository.save(bill);
        log.info("Fatura yüklendi");
        log.info(bill.toString());
    }

    private void customerLoader() {
        Customer customer = new Customer();
        customer.setFirstname("Hüdai");
        customer.setLastname("APA");
        customer.setPhone("+905466852635");
        customer.setEmail("hudaiapa@gmail.com");
        Address address = Address.builder()
                .country("Türkiye")
                .province("Denizli")
                .district("Acıpayam")
                .neighbourhood("Aşağı Mahalle")
                .fullAddress("No:23 Kat:1 Daire:1")
                .build();
        customer.setAddress(address);
        customerRepository.save(customer);

        log.info("Müşteri 1  yüklendi");
        log.info(customer.toString());
        Customer customer1 = new Customer();
        customer1.setFirstname("Haldun");
        customer1.setLastname("APA");
        customer1.setPhone("+905466782635");
        customer1.setEmail("haldunapa@gmail.com");
        Address address1 = Address.builder()
                .country("Türkiye")
                .province("Denizli")
                .district("Pamukkale")
                .neighbourhood("Asmalıevler Mahalle")
                .fullAddress("No:78 Kat:7 Daire:2")
                .build();
        customer1.setAddress(address);
        customerRepository.save(customer1);
        log.info("Müşteri 2  yüklendi");
        log.info(customer1.toString());
    }

    private void orderLineLoader() {
        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(productRepository.findAll().stream().findFirst().get());
        orderLine.setQuantity(2);
        orderLine.setTotalPrice(productRepository.findAll().stream().findFirst().get().getPrice().multiply(new BigDecimal(2)));
        orderLineRepository.save(orderLine);
        log.info("Sipariş kalemleri yüklendi");
        log.info(orderLine.toString());
        stockRepository.findAll().stream().findFirst().get().setQuantity(stockRepository.findAll().stream().findFirst().get().getQuantity() - orderLine.getQuantity());
        log.info("Stoktan ürün düşüldü");
        log.info(stockRepository.findAll().stream().findFirst().get().getProduct().getTitle()+" ürünü için mevcut stok " +stockRepository.findAll().stream().findFirst().get().getQuantity());
    }

    private void orderLoader() {

        Order order = new Order();
        Customer customer = customerRepository.findAll().stream().findFirst().get();
        order.setCustomer(customer);
        order.setAddress(customer.getAddress());
        orderRepository.save(order);
        log.info("Sipariş yüklendi");
        log.info(order.toString());
        order= orderRepository.findAll().stream().findFirst().get();
        orderLineLoader();
        List<OrderLine> orderLines = List.of(orderLineRepository.findAll().stream().findFirst().get());
        order.setTotalPrice(orderLines.stream().map(OrderLine::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        order.setOrderLines(orderLines);

    }

    private void productLoader() {
        Product product = new Product();
        product.setTitle("Iphone 12 Max");
        product.setPrice(new BigDecimal(13000L));
        productRepository.save(product);
        log.info("Ürün yüklendi");
        log.info(product.toString());
    }

    private void stockLoader() {
        Stock stock = new Stock();
        stock.setProduct(productRepository.findAll().stream().findFirst().get());
        stock.setQuantity(1000);
        stockRepository.save(stock);
        log.info("Stok yüklendi");
        log.info(stock.toString());
    }
}
