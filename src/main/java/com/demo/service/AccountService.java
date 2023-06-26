package com.demo.service;

import com.demo.model.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public void save(Account account);
    public void deleteById(String id);
    public Account getById(String id);
    Account searchByUsername(String username,String password);
}
