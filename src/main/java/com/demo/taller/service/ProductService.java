package com.demo.taller.service;

import com.demo.taller.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product createProduct(Product product);
    Product updateProduct(String id, Product product);
    Product addStock(String id, int quantity);
    Product buyProduct(String id, int quantity);
    void deleteProduct(String id);
}
