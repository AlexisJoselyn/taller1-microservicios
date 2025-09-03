package com.demo.taller.service.impl;

import com.demo.taller.model.Product;
import com.demo.taller.repository.ProductRepository;
import com.demo.taller.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        return repository.save(existing);
    }

    @Override
    public Product addStock(String id, int quantity) {
        Product existing = getProductById(id);
        existing.setStock(existing.getStock() + quantity);
        return repository.save(existing);
    }

    @Override
    public Product buyProduct(String id, int quantity) {
        Product existing = getProductById(id);
        if (existing.getStock() < quantity) {
            throw new RuntimeException("Not enough stock");
        }
        existing.setStock(existing.getStock() - quantity);
        return repository.save(existing);
    }

    @Override
    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
