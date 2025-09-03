package com.demo.taller.controller;

import com.demo.taller.model.Product;
import com.demo.taller.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
//listar producto
    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return service.getProductById(id);
    }
 //registrar producto
    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }
//actualizar stock
    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }
    //consultar stock
    @PatchMapping("/{id}/stock")
    public Product addStock(@PathVariable String id, @RequestParam int quantity) {
        return service.addStock(id, quantity);
    }

    @PostMapping("/{id}/buy")
    public Product buyProduct(@PathVariable String id, @RequestParam int quantity) {
        return service.buyProduct(id, quantity);
    }
//eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteProduct(id);
    }
}
