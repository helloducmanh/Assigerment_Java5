package com.demo.service;

import com.demo.model.Order;
import com.demo.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public List<OrderDetail> findAll();
    public OrderDetail getById(Long id);
    public void deleteById(Long id);
    public  void save(OrderDetail orderDetail);
}
