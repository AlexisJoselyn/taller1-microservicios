package com.demo.test.service.impl;

import com.demo.test.model.Product;
import com.demo.test.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Implementación  de CustomerService.
 * Usamos un Map como "base de datos en memoria".
 *
 */

@Service
public class ProductServiceImpl implements ProductService {
    // Simulamos la BD con un Map
    private final Map<Long, Product> store = new LinkedHashMap<>();
    private long seq = 1L;      // contador para generar IDs

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());     // retorna todos los clientes
    }

    @Override
    public Product findById(Long id) {
        return store.get(id);       // busca por ID
    }

    @Override
    public Product save(Product c) {
        // si no tiene ID, le asignamos uno nuevo
        if (c.getId() == null) c.setId(seq++);
        store.put(c.getId(), c);    // lo guardamos en el Map
        return c;
    }

    @Override
    public void delete(Long id) {
        store.remove(id);   // lo guardamos en el Map
    }
}
