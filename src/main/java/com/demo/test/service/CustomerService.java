package com.demo.test.service;

import com.demo.test.model.Customer;
import java.util.List;
/**
 * Interfaz que define qué operaciones puede hacer el servicio de clientes.
 * Esto nos ayuda a mantener un diseño limpio (programar contra interfaces).
 */
public interface CustomerService {
    List<Customer> findAll();           // obtener todos los clientes
    Customer findById(Long id);         // buscar cliente por ID
    Customer save(Customer c);          // guardar o crear cliente
    void delete(Long id);               // eliminar cliente
}
