package com.cocosun.learn.model.customer;

import java.util.List;

import com.cocosun.learn.model.order.Order;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;
    private List<Order> orders; // One-to-many

}
