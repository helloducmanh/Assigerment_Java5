package com.demo.controller;

import com.demo.service.ImPL.OrderDetailServiceIMPL;
import com.demo.service.ImPL.OrderServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderDetailController {
    @Autowired
    OrderDetailServiceIMPL orderDetailServiceIMPL;
    @GetMapping("admin/orderdetail/hien-thi")
    public String index(Model model){
        model.addAttribute("dsOrderDetail",orderDetailServiceIMPL.findAll());
        return "admin/orderdetail/list";
    }
}
