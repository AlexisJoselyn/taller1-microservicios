package com.demo.test.controller;

import com.demo.test.model.Customer;
import com.demo.test.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST de clientes.
 * Expone endpoints HTTP (GET, POST, DELETE) que se documentan automáticamente en Swagger.
 */

@Tag(name = "Customers", description = "Operaciones CRUD de clientes ")
@RestController
@RequestMapping("/api/customers")   // todos los endpoints empiezan con /api/customers
public class CustomerController {

    private final CustomerService service;
    // Spring inyecta la implementación de CustomerService
    public CustomerController(CustomerService service) { this.service = service; }

    @Operation(summary = "Listar clientes")
    @GetMapping
    public List<Customer> all() {
        return service.findAll();   // devuelve todos
    }

    @Operation(summary = "Obtener cliente por id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "No encontrado")
            })
    @GetMapping("/{id}")
    public Customer byId(@PathVariable Long id) {
        var c = service.findById(id);
        if (c == null) throw new RuntimeException("Customer not found");
        return c;
    }

    @Operation(summary = "Crear cliente")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@Valid @RequestBody Customer body) {
        return service.save(body);      // crea uno nuevo
    }

    @Operation(summary = "Eliminar cliente")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);     // borra por ID
    }
}
