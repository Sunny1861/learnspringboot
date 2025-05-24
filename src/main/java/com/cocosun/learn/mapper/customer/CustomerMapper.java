package com.cocosun.learn.mapper.customer;

import java.util.List;

import com.cocosun.learn.model.customer.Customer;

public interface CustomerMapper {

    List<Customer> findAllCustomersWithOrders();

    Customer findCustomerById(long id);
}
