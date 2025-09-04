package com.demo.taller.service;

import com.demo.taller.model.Product;
import com.demo.taller.model.dto.*;

import java.util.List;

public interface ProductService {
    List<Product> list();
    Product create(ProductCreateRequest req);
    Product getById(String id);
    Product update(String id, ProductUpdateRequest req); // sin tocar stock
    void delete(String id);
    Product addStock(String id, StockUpdateRequest req);
    PurchaseResponse purchase(String id, PurchaseRequest req);
}
