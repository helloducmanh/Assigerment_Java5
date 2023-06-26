package com.demo.controller;

import com.demo.model.Category;
import com.demo.service.CategoryService;
import com.demo.service.ImPL.CategoryServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryServiceIMPL cateService;
    //  Category
    @GetMapping("/admin/category/index")
    public String listCategory(Model model) {
        model.addAttribute("cateList", cateService.findAll());
        return "admin/category/list";
    }

    @GetMapping("/admin/category/create")
    public String createCategory() {
        return "admin/category/form";
    }

    @PostMapping("/admin/category/save")
    public String saveCategory(Category category) {
        cateService.save(category);
        return "redirect:/admin/category/index";
    }

    @GetMapping("/admin/category/edit/{id}")
    public String editCategory(@PathVariable String id, Model model) {
        Category category = cateService.getById(id);
        model.addAttribute("category", category);
        return "admin/category/form_update";
    }

    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable String id, Model model) {
        cateService.deleteById(id);
        return "redirect:/admin/category/index";
    }

    @PostMapping("/admin/category/update/{id}")
    public String updateCategory(@PathVariable String id, @ModelAttribute("category") Category category, Model model) {
        cateService.save(category);
        return "redirect:/admin/account/index";
    }
}
