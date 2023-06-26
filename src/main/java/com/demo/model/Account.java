package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "fullname")
    String fullname;
    @Column(name = "email")
    String email;
    @Column(name = "photo")
    String photo;
    @Column(name = "activated")
    boolean activated;
    @Column(name = "admin")
    boolean admin;
}
