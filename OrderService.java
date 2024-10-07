package com.orders.orderservice.service;

import com.orders.orderservice.client.domain.Product;
import com.orders.orderservice.domain.Order;
import com.orders.orderservice.entity.OrderEntity;
import com.orders.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Order createOrder(Order order) {
        OrderEntity entity = null;
        Product product = getProduct(order.getProductID());
        OrderEntity orderEntity = convert(order, product.getID());
        OrderEntity newOrderEntity = orderRepository.save(orderEntity);
        return convert(newOrderEntity);
    }

    private Order convert(OrderEntity orderEntity) {
        Order order = new Order();
        order.setOrderId(orderEntity.getID());
        return order;
    }
    private Product getProduct(Long productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String url = "http://localhost:8081/{productId}";
        url = url.replace("{productId}", String.valueOf(productId));
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    private OrderEntity convert(Order order, Long productId) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerName(order.getCustomerName());
        orderEntity.setProductIDs(String.valueOf(productId));
        orderEntity.setOrderDate(new Date());
        return orderEntity;
    }

}
