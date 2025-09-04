package com.demo.taller.service.impl;

import com.demo.taller.model.Product;
import com.demo.taller.model.dto.*;
import com.demo.taller.repository.ProductRepository;
import com.demo.taller.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.demo.taller.exception.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    @Override
    public List<Product> list() {
        return repo.findAll();
    }

    @Override
    public Product create(ProductCreateRequest req) {
        Product p = Product.builder()
                .name(req.getName())
                .price(req.getPrice())
                .stock(req.getStock())
                .build();
        return repo.save(p);
    }

    @Override
    public Product getById(String id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public Product update(String id, ProductUpdateRequest req) {
        Product db = getById(id);
        db.setName(req.getName());
        db.setPrice(req.getPrice());
        return repo.save(db);
    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id)) throw new NotFoundException("Product not found");
        repo.deleteById(id);
    }
    @Override
    public Product addStock(String id, StockUpdateRequest req) {
        Product db = getById(id);
        db.setStock(db.getStock() + req.getQuantity());
        return repo.save(db);
    }

    @Override
    public PurchaseResponse purchase(String id, PurchaseRequest req) {
        Product db = getById(id);
        int q = req.getQuantity();
        Assert.isTrue(q > 0, "Quantity must be > 0");
        if (db.getStock() < q) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        db.setStock(db.getStock() - q);
        repo.save(db);
        return PurchaseResponse.builder()
                .productId(db.getId())
                .quantity(q)
                .remainingStock(db.getStock())
                .totalAmount(db.getPrice() * q)
                .build();
    }
}
