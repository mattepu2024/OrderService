package com.orders.orderservice.controller;

import com.orders.orderservice.domain.Order;
import com.orders.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
public class OrderServiceController {

    private Logger log = LoggerFactory.getLogger(OrderServiceController.class);

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create")
    public Long createOrder(@RequestBody Order order) {
        Long orderId = null;
        log.info("Received request to create an order for given products ");
        try {
            Order order1 =  orderService.createOrder(order);
            orderId = order1.getOrderId();
        } catch (Exception e) {
            log.error(" Order creation failed for given products ");
        }
        return orderId;
    }
}
