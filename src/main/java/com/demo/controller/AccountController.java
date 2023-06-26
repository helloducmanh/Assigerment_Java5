package com.demo.controller;

import com.demo.model.Account;
import com.demo.service.ImPL.AccountServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    AccountServiceIMPL accountServiceIMPL;
    @Autowired
    HttpSession session;
    @GetMapping("/admin/account/index")
    public String listAccount(Model model) {
        model.addAttribute("danhSachAc", accountServiceIMPL.findAll());
        return "admin/account/list";
    }

    @GetMapping("/admin/account/create")
    public String createAccount() {
        return "admin/account/form";
    }

    @PostMapping("/admin/account/save")
    public String saveAccount(Account account) {
        accountServiceIMPL.save(account);
        return "redirect:/";
    }

    @GetMapping("/admin/account/edit/{id}")
    public String editAccount(@PathVariable String id, Model model) {
        Account account = accountServiceIMPL.getById(id);
        model.addAttribute("account", account);
        return "admin/account/form_update";
    }

    @GetMapping("/admin/account/delete/{id}")
    public String deleteAccount(@PathVariable String id, Model model) {
        accountServiceIMPL.deleteById(id);
        return "redirect:/admin/account/index";
    }

    @PostMapping("/admin/account/update/{id}")
    public String updateAccount(@PathVariable String id, @ModelAttribute("account") Account account, Model model) {
        accountServiceIMPL.save(account);
        System.out.println("sua thanh cong");
        return "redirect:/admin/account/index";
    }


}
