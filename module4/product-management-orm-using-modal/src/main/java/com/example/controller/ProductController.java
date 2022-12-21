package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.impl.ProductService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    static {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            sessionFactory.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private IProductService productService = new ProductService();

    @GetMapping(value = "/show-list")
    public String showProductList(Model model) {
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        Product product = new Product();
        model.addAttribute("product",product);
        return "list";
    }


    @PostMapping(value = "/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        String mess = productService.editProduct(product);
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }


    @PostMapping(value = "/add")
    public String addProduct(Product product, RedirectAttributes redirectAttributes) {
        boolean check = productService.addNewProduct(product);
        String mess = null;
        if (check) {
            mess = "Was successfully added";
        } else {
            mess = "Failed to add";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }

@PostMapping(value = "/delete")
public String deleteProduct(Product product, RedirectAttributes redirectAttributes){
        boolean check = productService.deleteProduct(product.getId());
        String mess ;
        if (check){
            mess = "Successfully deleted";
        } else {
            mess = "Failed to delete";
        }
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/show-list";
}
@GetMapping(value = "/search")
public String searchByName(Model model, @RequestParam("searchName") String name){
List<Product> productList = productService.searchByName(name);
model.addAttribute("productList",productList);
    Product product = new Product();
    model.addAttribute("product",product);
    return "list";
}
}
