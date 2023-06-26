package com.demo.service.ImPL;

import com.demo.model.OrderDetail;
import com.demo.repo.OrderDetailRepo;
import com.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceIMPL implements OrderDetailService {
    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepo.findAll();
    }

    @Override
    public OrderDetail getById(Long id) {
        return orderDetailRepo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        orderDetailRepo.deleteById(id);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepo.save(orderDetail);
    }
}
