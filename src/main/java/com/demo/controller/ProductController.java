package com.demo.controller;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.service.ImPL.CategoryServiceIMPL;
import com.demo.service.ImPL.ProductServiceIMPL;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class ProductController {
  @Autowired
    ProductServiceIMPL productServiceIMPL;
  @Autowired
    CategoryServiceIMPL categoryServiceIMPL;
    //  Product
    @GetMapping("/admin/product/index")
    public String listProduct(Model model) {
        model.addAttribute("danhSachSP", productServiceIMPL.findAll());
        return "admin/product/list";
    }

    @GetMapping("/admin/product/create")
    public String createProduct(Model model) {
        model.addAttribute("category", categoryServiceIMPL.findAll());
        return "admin/product/form";
    }


    @PostMapping("/admin/product/save")
    public String create( Model model, @RequestParam("name") String name,
                          @RequestParam("price") String price,
                          @RequestParam("category") String categoryID,
                          @RequestParam("image") MultipartFile image

    ) throws IOException {
//        convert multipartfile to base64
        byte[] img = Base64.getEncoder().encode(image.getBytes());
        String imgBase64 = new String(img);
        Product product = new Product();
        Category category = categoryServiceIMPL.getById(categoryID);
        product.setName(name);
        product.setPrice(Integer.parseInt(price));
        product.setCategory(category);
        product.setImage(imgBase64);
        productServiceIMPL.save(product);
        return "redirect:/admin/product/index";
    }

    @GetMapping("/admin/product/edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Product product = productServiceIMPL.getById(id);
        model.addAttribute("pro duct", product);
        model.addAttribute("category", categoryServiceIMPL.findAll());
        return "admin/product/form_update";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable int id, Model model) {
        productServiceIMPL.deleteById(id);
        return "redirect:/admin/product/index";
    }

    // cập nhật sản phẩm
    @PostMapping("/admin/product/update/{id}")
    public String updateAccount(@PathVariable("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("price") String price,
                                @RequestParam("category") String categoryID,
                                @RequestParam("image") MultipartFile image) throws IOException {
        Product product = this.productServiceIMPL.getById(Integer.parseInt(id));
        if (!image.isEmpty()){
            byte[] img = Base64.getEncoder().encode(image.getBytes());
            product.setImage(new String(img));
        }


        product.setName(name);
        product.setPrice(Integer.parseInt(price));
        product.setCategory(this.categoryServiceIMPL.getById(categoryID));
        productServiceIMPL.save(product);
        return "redirect:/admin/product/index";
    }

}
