package com.example.service.impl;



import com.example.model.Product;
import com.example.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "car", 123.1, "good", "Toyata"));
        productList.add(new Product(2, "car", 600, "good", "Ford"));
        productList.add(new Product(3, "bike", 1000, "good", "Toyata"));
        productList.add(new Product(4, "motorbike", 123.1, "good", "Toyata"));
        productList.add(new Product(5, "car", 123.1, "good", "Audi"));
    }

    public List<Product> getAllProduct() {
        return productList;
    }

    public boolean addNewProduct(Product product) {
        return productList.add(product);
    }

    public boolean deleteProduct(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return productList.remove(p);
            }
        }
        return false;
    }

    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public String editProduct(Product product) {
        Integer index = null;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                index = i;
                break;
            }
        }
        if (index != null) {
            return "failed to edit";
        }
        productList.set(index, product);
        return "Successfully deleted";
    }
}
