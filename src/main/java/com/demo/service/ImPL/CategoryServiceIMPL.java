package com.demo.service.ImPL;

import com.demo.model.Category;
import com.demo.repo.CategoryRepo;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceIMPL implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public CategoryServiceIMPL() {

    }

    @Override
    public Category getById(String id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        categoryRepo.deleteById(id);

    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
