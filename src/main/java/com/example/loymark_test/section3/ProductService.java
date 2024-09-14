package com.example.loymark_test.section3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("Product 1", 100.0, "Product 1 description"));
        products.add(new Product("Product 2", 200.0, "Product 2 description"));
        products.add(new Product("Product 3", 300.0, "Product 3 description"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
