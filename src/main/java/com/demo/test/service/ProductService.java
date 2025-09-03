package com.demo.test.service;

import com.demo.test.model.Product;
import java.util.List;
/**
 * Interfaz que define qué operaciones puede hacer el servicio de clientes.
 * Esto nos ayuda a mantener un diseño limpio (programar contra interfaces).
 */
public interface ProductService {
    List<Product> findAll();           // obtener todos los clientes
    Product findById(Long id);         // buscar cliente por ID
    Product save(Product c);          // guardar o crear cliente
    void delete(Long id);               // eliminar cliente
}
