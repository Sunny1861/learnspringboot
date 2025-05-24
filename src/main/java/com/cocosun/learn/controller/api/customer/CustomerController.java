package com.cocosun.learn.controller.api.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocosun.learn.mapper.customer.CustomerMapper;
import com.cocosun.learn.model.customer.Customer;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    /**
     * GET /customers Returns a list of customers with their orders (LEFT JOIN).
     */
    @Operation(summary = "List all customers and theirs orders")
    @GetMapping
    public List<Customer> getAllCustomersWithOrders() {
        return customerMapper.findAllCustomersWithOrders();
    }

    @Operation(summary = "Get one customer and orders")
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerMapper.findCustomerById(id);

    }
}
