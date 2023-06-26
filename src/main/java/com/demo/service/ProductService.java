package com.demo.service;

import com.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product getById(Integer id);
    public void deleteById(Integer id);
    public void save(Product product);
    Page<Product> searchByCategoryNamePrice(String cid, String keyword, int minPrice, int maxPrice, Pageable pageable);
    Page<Product> searchByNamePrice(String keyword,int minPrice,int maxPrice,Pageable pageable);
}
