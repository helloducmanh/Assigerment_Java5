package com.demo.controller;

import com.demo.model.Account;
import com.demo.model.Order;
import com.demo.model.OrderDetail;
import com.demo.model.Product;
import com.demo.repo.AccountRepository;
import com.demo.service.AccountService;
import com.demo.service.CategoryService;
import com.demo.service.ImPL.*;
//import com.demo.service.CategoryService;
//import com.demo.service.ProductService;
import com.demo.repo.CategoryRepo;
import com.demo.repo.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	HttpSession session;

	@Autowired
	CategoryServiceIMPL categoryServiceIMPL;

	@Autowired
	ProductServiceIMPL productServiceIMPL;

	@Autowired
	CartService cart;
	@Autowired
	OrderServiceIMPL orderServiceIMPL;

	@Autowired
	AccountServiceIMPL accountServiceIMPL;

	@Autowired
	OrderDetailServiceIMPL orderDetailServiceIMPL;

	@ModelAttribute("cart")
	CartService getCart(){
		return cart;
	}

	@Data @AllArgsConstructor
	public static class PriceRange{
		int id;
		int minValue;
		int maxValue;
		String display;
	}

	List<PriceRange> priceRangeList = Arrays.asList(
		new PriceRange(0,0, Integer.MAX_VALUE, "Tất cả"),
		new PriceRange(1,0, 10000000, "Dưới 10 triệu"),
		new PriceRange(2,10000000, 20000000, "Từ 10-20 triệu"),
		new PriceRange(3,20000000, Integer.MAX_VALUE, "Trên 20 triệu")
	);

	@RequestMapping("/")
	public String index(
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="") String categoryId,
			@RequestParam(defaultValue="0") int priceRangeId,
			@RequestParam(defaultValue="0") int pageNo,
			Model model) {


		model.addAttribute("priceRangeList", priceRangeList);
		model.addAttribute("cateList",categoryServiceIMPL.findAll());

		int minPrice = priceRangeList.get(priceRangeId).minValue;
		int maxPrice = priceRangeList.get(priceRangeId).maxValue;
		Pageable pageable = PageRequest.of(pageNo,6);
		model.addAttribute("listProduct",productServiceIMPL.findAll());
		// TODO: Search & paginate
		if(categoryId.isEmpty()){
			Page<Product> productPage1= productServiceIMPL.searchByNamePrice("%"+keyword+"%",minPrice,maxPrice,pageable);
           model.addAttribute("listProduct",productPage1);
		}else{
			Page<Product> productPage2= productServiceIMPL.searchByCategoryNamePrice(categoryId,"%"+keyword+"%",minPrice,maxPrice,pageable);
			model.addAttribute("listProduct",productPage2);
		}

		return "home/index";
	}
	@GetMapping("/detail/{id}")
	public String viewProduct(@PathVariable int id, Model model) {
		Product product =productServiceIMPL.getById(id);
		model.addAttribute("product",product);
		return "home/detail";
	}

	@RequestMapping("/add-to-cart/{id}")
	public String addToCart(@PathVariable int id){
		if(session.getAttribute("userCurrent") == null){
			return  "redirect:/login";
		}
		cart.add(id);
		return "redirect:/cart";
	}

	@RequestMapping("/remove-cart/{id}")
	public String removeCart(@PathVariable int id) {
		cart.remove(id);
		if(cart.getTotal() == 0){
			return "redirect:/";
		}
		return "redirect:/cart";
	}

	@RequestMapping("/update-cart/{id}")
	public String updateCart(@PathVariable int id, int quantity) {
		cart.update(id, quantity);
		return "redirect:/cart";
	}

	@GetMapping("/cart")
	public String cart(){
		return "home/cart";
	}

	@GetMapping("/confirm")
	public String confirm(){
		return "home/confirm";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		return "home/about";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@GetMapping("/logout")
	public String logout(){
		session.removeAttribute("username");
		return "redirect:/login";
	}
	@GetMapping("/form_dangky")
	public String register(){
		return "form_dangky";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		// TODO: Check if user/password exists in database
		for(Account i : accountServiceIMPL.findAll()) {
			if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
				Account acc = accountServiceIMPL.searchByUsername(username,password);
				session.setAttribute("userCurrent",acc);
				if(i.isAdmin()==true){
					return "redirect:/admin/category/index";
				}
					return "redirect:/";

			}
		}
		model.addAttribute("message", "Tên đăng nhập/mật khẩu không đúng");
		return "login";
	}

	@PostMapping("/purchase")
	public String purchase(@RequestParam String address){
		System.out.println("address=" + address);
		System.out.println("items=" + cart.getItems());
		// TODO: Save items to database
		Account account= (Account) session.getAttribute("userCurrent");
		if(account != null){
			System.out.println("hehe");
			Order order = new Order();
			order.setAccount(account);
			order.setAddress(address);
			orderServiceIMPL.save(order);
			for (OrderDetail item: cart.getItems()){
				item.setOrder(order);
				orderDetailServiceIMPL.save(item);
			}
			cart.clear();
		}
		return "redirect:/";
	}


}
