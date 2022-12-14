package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findByName(String name);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
}
