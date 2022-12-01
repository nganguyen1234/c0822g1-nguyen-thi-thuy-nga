package repository.impl;

import model.Product;
import repository.IProductRepository;
import service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "car", 123, "good", "Toyata"));
        productList.add(new Product(2, "car", 123, "good", "Ford"));
        productList.add(new Product(3, "motorbike", 123, "good", "Hyundai"));
        productList.add(new Product(4, "car", 123, "good", "Audi"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findByName(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, product);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product);
            }
        }
    }
}
