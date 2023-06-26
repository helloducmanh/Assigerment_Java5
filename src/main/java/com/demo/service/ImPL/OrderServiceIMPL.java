package com.demo.service.ImPL;

import com.demo.model.Order;
import com.demo.repo.OrderRepository;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceIMPL implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void save(Order order) {
       orderRepository.save(order);
    }
}
