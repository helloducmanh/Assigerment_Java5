package com.demo.controller;

import com.demo.service.ImPL.OrderServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderConTroller {
    @Autowired
    OrderServiceIMPL orderServiceIMPL;
    @GetMapping("/admin/order/index")
    public String index(Model model){
        model.addAttribute("dsOrder",orderServiceIMPL.findAll() );
        return "admin/order/list";
    }
}
