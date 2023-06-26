package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="orderdetails")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer price;
    Integer quantity;
    @ManyToOne
    @JoinColumn(name="productid")
    Product product;
    @ManyToOne
    @JoinColumn(name="orderid")
    Order order;
}
