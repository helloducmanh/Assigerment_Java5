package com.demo.service;

import com.demo.model.Order;

import java.util.List;

public interface OrderService {
      public List<Order> findAll();
      public Order getById(Long id);
      public void deleteById(Long id);
      public  void save(Order order);
}
