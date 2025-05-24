package com.cocosun.learn.model.customer;

import java.util.List;

import com.cocosun.learn.model.order.Order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(hidden = true)
public class Customer {

    private Long id;
    private String name;
    private List<Order> orders; // One-to-many

}
