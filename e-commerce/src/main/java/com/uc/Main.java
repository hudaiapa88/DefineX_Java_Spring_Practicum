package com.uc;

import com.uc.model.Bill;
import com.uc.model.Customer;
import com.uc.repo.loader.RepoLoader;
import com.uc.service.BillManager;
import com.uc.service.CustomerManager;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    private static BillManager billManager=BillManager.getInstance();
    private static CustomerManager customerManager=CustomerManager.getInstance();
    public static void main(String[] args) {
        RepoLoader repoLoader= new RepoLoader();
        System.out.println();
        System.out.println("İçerisinde C harfi geçen müşteriler");
        List<Customer> customers= customerManager.getCustomerFirstnameInCharacter("C");
        customers.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Haziran ayında kayıt olan müşterilerin faturalarınının toplam tutarı");
        List<Bill> bills=billManager.getByCustomerAndMonth(6);
        bills.stream().forEach(bill -> {System.out.println("Tutar : "+bill.getOrder().getTotalPrice());});

        System.out.println();
        System.out.println("Sistemdeki tüm faturalar");
        List<Bill> allBills=billManager.getAll();
        allBills.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Sistemdeki 1500TL üstündeki faturalar");
        List<Bill> bills1 =billManager.getByOrderTotalPriceGraterThan(new BigDecimal(1500));
        bills1.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Sistemdeki 1500TL üstündeki faturaları ortalaması");
        BigDecimal average =billManager.getByOrderTotalPriceGraterThanAndAverage(new BigDecimal(1500));
        bills1.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri");
        List<String> customerFirstnames=billManager.getByCustomerFirstnameAndOrderTotalPriceLessThan(new BigDecimal(500));
        customerFirstnames.stream().forEach(System.out::println);
    }
}