package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    private IProductService productService = new ProductService();

    @GetMapping(value = "/show-list")
    public String showProductList(Model model) {
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping(value = "/show-edit-form/{id}")
    public String showEditForm(Model model, @PathVariable("id") int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "editForm";
    }

    @PostMapping(value = "/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        String mess = productService.editProduct(product);
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }

    @GetMapping(value = "/show-add-form")
    public String showAddForm(Model model) {
        model.addAttribute("product",new Product());
        return "addForm";
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
    @GetMapping(value = "/show-delete-form/{id}")
public String showDeleteForm(Model model,@PathVariable("id") int id){
        model.addAttribute("product",productService.findById(id));
        return "delete";
}

public String deleteProduct(Product product, RedirectAttributes redirectAttributes){
        boolean check = productService.deleteProduct(product.getId());
        String mess ;
        if (check){
            mess = "Successfully deleted";
        } else {
            mess = "Failed to delete";
        }
        return "redirect:/show-list";
}
}
