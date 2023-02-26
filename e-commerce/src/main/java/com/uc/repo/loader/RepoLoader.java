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
        bill.setBillDate(LocalDateTime.of(2023,1,12,00,00));
        bill.setOrder(orderRepository.findAll().get(0));
        billRepository.save(bill);
        Bill bill1= new Bill();
        bill1.setBillDate(LocalDateTime.of(2023,1,2,00,00));
        bill1.setOrder(orderRepository.findAll().get(1));
        billRepository.save(bill1);
        Bill bill2= new Bill();
        bill2.setBillDate(LocalDateTime.of(2023,1,3,00,00));
        bill2.setOrder(orderRepository.findAll().get(2));
        billRepository.save(bill2);
        Bill bill3= new Bill();
        bill3.setBillDate(LocalDateTime.of(2023,1,14,00,00));
        bill3.setOrder(orderRepository.findAll().get(3));
        billRepository.save(bill3);
        Bill bill4= new Bill();
        bill4.setBillDate(LocalDateTime.of(2023,1,7,00,00));
        bill4.setOrder(orderRepository.findAll().get(4));
        billRepository.save(bill4);
        log.info("Fatura yüklendi");
      //  log.info(bill.toString());
    }

    private void customerLoader() {

        Customer customer = new Customer();
        customer.setCreatedDateTime(LocalDateTime.of(2022,4,01,00,06));
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
        customer1.setCreatedDateTime(LocalDateTime.of(2022,6,7,9,00));
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
        customer1.setAddress(address1);
        customerRepository.save(customer1);
        log.info("Müşteri 2  yüklendi");
        log.info(customer1.toString());


        Customer customer2 = new Customer();
        customer2.setCreatedDateTime(LocalDateTime.of(2022,3,7,9,00));
        customer2.setFirstname("Canan");
        customer2.setLastname("AKÇEŞME");
        customer2.setPhone("+905456782635");
        customer2.setEmail("canan@gmail.com");
        Address address2 = Address.builder()
                .country("Türkiye")
                .province("Denizli")
                .district("Pamukkale")
                .neighbourhood("Pınarcık Mahalle")
                .fullAddress("No:78 Kat:7 Daire:2")
                .build();
        customer2.setAddress(address2);
        customerRepository.save(customer2);
        log.info("Müşteri 3  yüklendi");
        log.info(customer2.toString());


        Customer customer3 = new Customer();
        customer3.setCreatedDateTime(LocalDateTime.of(2022,6,8,9,00));
        customer3.setFirstname("Asım");
        customer3.setLastname("Alamak");
        customer3.setPhone("+905566782635");
        customer3.setEmail("asımkcesme@gmail.com");
        Address address3 = Address.builder()
                .country("Türkiye")
                .province("Denizli")
                .district("Pamukkale")
                .neighbourhood("Pınarcık Mahalle")
                .fullAddress("No:78 Kat:8 Daire:2")
                .build();
        customer3.setAddress(address3);
        customerRepository.save(customer3);
        log.info("Müşteri 4  yüklendi");
        log.info(customer3.toString());

        Customer customer4 = new Customer();
        customer4.setCreatedDateTime(LocalDateTime.of(2022,6,2,9,00));
        customer4.setFirstname("Celal");
        customer4.setLastname("Alkan");
        customer4.setPhone("+905456778635");
        customer4.setEmail("celal@gmail.com");
        Address address4 = Address.builder()
                .country("Türkiye")
                .province("Denizli")
                .district("Pamukkale")
                .neighbourhood("Pınarcık Mahalle")
                .fullAddress("No:85 Kat:7 Daire:2")
                .build();
        customer4.setAddress(address4);
        customerRepository.save(customer4);
        log.info("Müşteri 5  yüklendi");
        log.info(customer4.toString());
    }

    private void orderLineLoader() {
        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(productRepository.findAll().get(0));
        orderLine.setQuantity(2);
        orderLine.setTotalPrice(productRepository.findAll().get(0).getPrice().multiply(new BigDecimal(orderLine.getQuantity())));
        orderLineRepository.save(orderLine);
        log.info("Sipariş kalemleri yüklendi");
        log.info(orderLine.toString());
        stockRepository.findAll().get(0).setQuantity(stockRepository.findAll().get(0).getQuantity() - orderLine.getQuantity());
        log.info("Stoktan ürün düşüldü");
        log.info(stockRepository.findAll().get(0).getProduct().getTitle()+" ürünü için mevcut stok " +stockRepository.findAll().get(0).getQuantity());

        OrderLine orderLine1 = new OrderLine();
        orderLine1.setProduct(productRepository.findAll().get(0));
        orderLine1.setQuantity(5);
        orderLine1.setTotalPrice(productRepository.findAll().get(0).getPrice().multiply(new BigDecimal(orderLine1.getQuantity())));
        orderLineRepository.save(orderLine1);
        log.info("Sipariş kalemleri yüklendi");
        log.info(orderLine1.toString());
        stockRepository.findAll().get(0).setQuantity(stockRepository.findAll().get(0).getQuantity() - orderLine1.getQuantity());
        log.info("Stoktan ürün düşüldü");
        log.info(stockRepository.findAll().get(0).getProduct().getTitle()+" ürünü için mevcut stok " +stockRepository.findAll().get(0).getQuantity());

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setProduct(productRepository.findAll().get(1));
        orderLine2.setQuantity(5);
        orderLine2.setTotalPrice(productRepository.findAll().get(1).getPrice().multiply(new BigDecimal(orderLine2.getQuantity())));
        orderLineRepository.save(orderLine2);
        log.info("Sipariş kalemleri yüklendi");
        log.info(orderLine2.toString());
        stockRepository.findAll().get(1).setQuantity(stockRepository.findAll().get(1).getQuantity() - orderLine2.getQuantity());
        log.info("Stoktan ürün düşüldü");
        log.info(stockRepository.findAll().get(1).getProduct().getTitle()+" ürünü için mevcut stok " +stockRepository.findAll().get(1).getQuantity());


        OrderLine orderLine3 = new OrderLine();
        orderLine3.setProduct(productRepository.findAll().get(2));
        orderLine3.setQuantity(5);
        orderLine3.setTotalPrice(productRepository.findAll().get(2).getPrice().multiply(new BigDecimal(orderLine3.getQuantity())));
        orderLineRepository.save(orderLine3);
        log.info("Sipariş kalemleri yüklendi");
        log.info(orderLine3.toString());
        stockRepository.findAll().get(2).setQuantity(stockRepository.findAll().get(2).getQuantity() - orderLine3.getQuantity());
        log.info("Stoktan ürün düşüldü");
        log.info(stockRepository.findAll().get(2).getProduct().getTitle()+" ürünü için mevcut stok " +stockRepository.findAll().get(2).getQuantity());

        OrderLine orderLine4 = new OrderLine();
        orderLine4.setProduct(productRepository.findAll().get(2));
        orderLine4.setQuantity(5);
        orderLine4.setTotalPrice(productRepository.findAll().get(2).getPrice().multiply(new BigDecimal(orderLine4.getQuantity())));
        orderLineRepository.save(orderLine4);
        log.info("Sipariş kalemleri yüklendi");
        log.info(orderLine3.toString());
        stockRepository.findAll().get(2).setQuantity(stockRepository.findAll().get(2).getQuantity() - orderLine4.getQuantity());
        log.info("Stoktan ürün düşüldü");
        log.info(stockRepository.findAll().get(2).getProduct().getTitle()+" ürünü için mevcut stok " +stockRepository.findAll().get(2).getQuantity());
    }

    private void orderLoader() {
        orderLineLoader();

        Order order = new Order();
        Customer customer = customerRepository.findAll().get(0);
        order.setCustomer(customer);
        order.setAddress(customer.getAddress());
        orderRepository.save(order);
        log.info("Sipariş yüklendi");
        log.info(order.toString());
        order= orderRepository.findAll().get(0);
        List<OrderLine> orderLines = List.of(orderLineRepository.findAll().get(0));
        order.setTotalPrice(orderLines.stream().map(OrderLine::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        order.setOrderLines(orderLines);


        Order order1 = new Order();
        Customer customer1 = customerRepository.findAll().get(1);
        order1.setCustomer(customer1);
        order1.setAddress(customer1.getAddress());
        orderRepository.save(order1);
        log.info("Sipariş yüklendi");
        log.info(order1.toString());
        order1= orderRepository.findAll().get(1);
        List<OrderLine> orderLines1 = List.of(orderLineRepository.findAll().get(1));
        order1.setTotalPrice(orderLines1.stream().map(OrderLine::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        order1.setOrderLines(orderLines1);

        Order order2 = new Order();
        Customer customer2 = customerRepository.findAll().get(2);
        order2.setCustomer(customer2);
        order2.setAddress(customer2.getAddress());
        orderRepository.save(order2);
        log.info("Sipariş yüklendi");
        log.info(order2.toString());
        order2= orderRepository.findAll().get(2);
        List<OrderLine> orderLines2 = List.of(orderLineRepository.findAll().get(2));
        order2.setTotalPrice(orderLines2.stream().map(OrderLine::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        order2.setOrderLines(orderLines2);

        Order order3 = new Order();
        Customer customer3 = customerRepository.findAll().get(3);
        order3.setCustomer(customer3);
        order3.setAddress(customer3.getAddress());
        orderRepository.save(order3);
        log.info("Sipariş yüklendi");
        log.info(order3.toString());
        order3= orderRepository.findAll().get(3);
        List<OrderLine> orderLines3 = List.of(orderLineRepository.findAll().get(3));
        order3.setTotalPrice(orderLines3.stream().map(OrderLine::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        order3.setOrderLines(orderLines3);

        Order order4 = new Order();
        Customer customer4 = customerRepository.findAll().get(4);
        order4.setCustomer(customer4);
        order4.setAddress(customer4.getAddress());
        orderRepository.save(order4);
        log.info("Sipariş yüklendi");
        log.info(order4.toString());
        order4= orderRepository.findAll().get(4);
        List<OrderLine> orderLines4 = List.of(orderLineRepository.findAll().get(1));
        order4.setTotalPrice(orderLines4.stream().map(OrderLine::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        order4.setOrderLines(orderLines4);


    }

    private void productLoader() {
        Product product = new Product();
        product.setTitle("Havlu");
        product.setPrice(new BigDecimal(100L));
        productRepository.save(product);
        Product product1 = new Product();
        product1.setTitle("Monster Laptop");
        product1.setPrice(new BigDecimal(20000L));
        productRepository.save(product1);
        Product product2 = new Product();
        product2.setTitle("Asus Laptop");
        product2.setPrice(new BigDecimal(19000L));
        productRepository.save(product2);
        Product product3 = new Product();
        product3.setTitle("Zippo çakmak");
        product3.setPrice(new BigDecimal(500L));
        productRepository.save(product3);
        log.info("Ürün yüklendi");
        log.info(product.toString());
    }

    private void stockLoader() {
        Stock stock = new Stock();
        stock.setProduct(productRepository.findAll().get(0));
        stock.setQuantity(1000);
        stockRepository.save(stock);
        Stock stock1 = new Stock();
        stock1.setProduct(productRepository.findAll().get(1));
        stock1.setQuantity(200);
        stockRepository.save(stock1);
        Stock stock2 = new Stock();
        stock2.setProduct(productRepository.findAll().get(2));
        stock2.setQuantity(125);
        stockRepository.save(stock2);
        Stock stock3 = new Stock();
        stock3.setProduct(productRepository.findAll().get(3));
        stock3.setQuantity(1004);
        stockRepository.save(stock3);
        log.info("Stok yüklendi");
        log.info(stock.toString());
    }
}
