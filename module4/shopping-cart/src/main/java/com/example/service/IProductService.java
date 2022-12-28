package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    Product findById(int id);
}
