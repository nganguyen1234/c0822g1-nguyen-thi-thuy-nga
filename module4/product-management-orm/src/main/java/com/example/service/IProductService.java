package com.example.service;



import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    boolean addNewProduct(Product product);
    boolean deleteProduct(int id);
    Product findById(int id);
    String editProduct(Product product);
    List<Product> searchByName(String searchName);

}
