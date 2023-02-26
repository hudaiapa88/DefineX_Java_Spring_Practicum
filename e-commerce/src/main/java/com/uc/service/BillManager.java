package com.uc.service;

import com.uc.model.Bill;
import com.uc.repo.BillRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import static org.apache.commons.lang3.compare.ComparableUtils.is;
public class BillManager {

    private static BillManager instance;
    BillRepository billRepository = BillRepository.getInstance();
    public static BillManager getInstance(){

        if (instance == null){
            instance = new BillManager();
        }

        return instance;
    }

   public List<Bill> getByCustomerAndMonth(Integer month){
    return billRepository.findAll().stream().filter((bill -> bill.getOrder().getCustomer().getCreatedDateTime().getMonthValue()==month)).collect(Collectors.toList());
    }
    public  List<Bill> getAll(){
        return billRepository.findAll();
    }
    public List<Bill> getByOrderTotalPriceGraterThan(BigDecimal amount){
         return billRepository.findAll().stream().filter((bill -> is(bill.getOrder().getTotalPrice()).greaterThan(amount))).collect(Collectors.toList());
    }
    public  BigDecimal getByOrderTotalPriceGraterThanAndAverage(BigDecimal amount){
        Double average= billRepository.findAll().stream().filter((bill -> is(bill.getOrder().getTotalPrice()).greaterThan(amount))).collect(Collectors.toList())
                .stream().map((bill -> bill.getOrder().getTotalPrice())).collect(Collectors.averagingDouble(BigDecimal::doubleValue));
        return new BigDecimal(average);
    }

    public  List<String> getByCustomerFirstnameAndOrderTotalPriceLessThan(BigDecimal amount){
        return billRepository.findAll().stream().filter(bill -> is(bill.getOrder().getTotalPrice()).lessThan(amount))
                .map(bill -> bill.getOrder().getCustomer().getFirstname()).collect(Collectors.toList());
    }

}
