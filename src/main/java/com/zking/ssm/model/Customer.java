package com.zking.ssm.model;

import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 一对多关联关系
 */
@ToString
public class Customer implements Serializable {
    private Integer customerId;

    private String customerName;

    private List<Order> orders=new ArrayList<>();
    public List<Order> getOrders() {

        return orders;
    }

    public void setOrders(List<Order> orders) {

        this.orders = orders;
    }



    public Customer(Integer customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Customer() {

        super();
    }



    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}