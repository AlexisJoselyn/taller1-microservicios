package com.demo.taller.controller;

import com.demo.taller.model.Product;
import com.demo.taller.model.dto.*;
import com.demo.taller.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> list() {
        return service.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody ProductCreateRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id,
                          @Valid @RequestBody ProductUpdateRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/{id}/stock/add")
    public Product addStock(@PathVariable String id,
                            @Valid @RequestBody StockUpdateRequest req) {
        return service.addStock(id, req);
    }

    @PostMapping("/{id}/purchase")
    public PurchaseResponse purchase(@PathVariable String id,
                                     @Valid @RequestBody PurchaseRequest req) {
        return service.purchase(id, req);
    }
}
