package com.demo.service;

import com.demo.model.Category;

import java.util.List;

public interface CategoryService {
    public Category getById (String id);
    public void deleteById(String id);
    public void save(Category category);
    public List<Category> findAll();
}
