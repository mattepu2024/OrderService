package com.orders.orderservice.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    Long ID;
    String name;
    String description;
    Double price;
    String imageURL;
}
