package com.example.dto;


import com.example.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {

    private int id;

    private Map<Product, Integer> productMap = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(Product product, int quantity) {
        if (productMap.containsKey(product)) {
            int value = productMap.get(product);
            productMap.put(product, value + quantity);
        } else {
            productMap.put(product, quantity);
        }
    }
}
