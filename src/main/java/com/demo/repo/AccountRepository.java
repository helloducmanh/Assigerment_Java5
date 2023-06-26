package com.demo.repo;

import com.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account,String> {
     @Query("Select p from Account p where p.username =?1 and p.password=?2")
     Account searchByAccount (String username,String password);
}
