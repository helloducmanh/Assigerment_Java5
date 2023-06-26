package com.demo.service.ImPL;

import com.demo.model.Product;
import com.demo.repo.ProductRepo;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceIMPL implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product getById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        productRepo.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Page<Product> searchByCategoryNamePrice(String cid, String keyword, int minPrice, int maxPrice, Pageable pageable) {
        return productRepo.searchByCategoryNamePrice(cid, keyword, minPrice, maxPrice, pageable);
    }

    @Override
    public Page<Product> searchByNamePrice(String keyword, int minPrice, int maxPrice, Pageable pageable) {
        return productRepo.searchByNamePrice(keyword, minPrice, maxPrice, pageable);
    }


}
