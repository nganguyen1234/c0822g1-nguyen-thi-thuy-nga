package com.example.controller;

import com.example.dto.CartDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping(value = "/show-list")
    public String showList(Model model) {
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping(value = "/show-detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "productDetail";
    }

    @GetMapping(value = "/add-product/{id}")
    public String addProduct(Model model, @PathVariable("id") int id, @SessionAttribute("cart") CartDto cartDto) {
        Product product = productService.findById(id);
        cartDto.addProduct(product, 1);
        return "redirect:/show-cart";
    }
}
