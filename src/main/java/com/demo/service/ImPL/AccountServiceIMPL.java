package com.demo.service.ImPL;

import com.demo.model.Account;
import com.demo.repo.AccountRepository;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceIMPL implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void save(Account account) {
            accountRepository.save(account);
    }

    @Override
    public void deleteById(String id) {
         accountRepository.deleteById(id);
    }

    @Override
    public Account getById(String id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account searchByUsername(String username, String password) {
        return accountRepository.searchByAccount(username, password);
    }}
