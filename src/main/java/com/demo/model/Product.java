package com.demo.model;

import lombok.*;

import javax.persistence.*;

@Table(name="Products")
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;
    @Column(name="name")
    String name;
    @Column(name="price")
    Integer price;
    @ManyToOne
    @JoinColumn(name="Categoryid")
     Category category;
    @Column(name="image", columnDefinition = "VARCHAR(MAX)")
     String image;
}
