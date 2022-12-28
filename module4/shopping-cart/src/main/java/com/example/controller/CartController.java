package com.example.controller;

import com.example.dto.CartDto;
import com.example.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;

@Controller
public class CartController {
    private CartDto cartDto;

    @GetMapping(value = "/show-cart")
    public String showCart(@SessionAttribute("cart") CartDto cartDto, Model model) {
        Map<Product, Integer> productMap = cartDto.getProductMap();
        model.addAttribute("productMap", productMap);
        return "cart";
    }

}
