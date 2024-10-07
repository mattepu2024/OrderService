package com.orders.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderEntity {
    @GeneratedValue
    @Id
    private Long ID;
    private String customerName;
    private String productIDs;
    private Date orderDate;
}
