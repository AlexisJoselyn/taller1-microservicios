package com.demo.test.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
/**
 * Clase modelo que representa a un Cliente.
 * Aquí definimos los atributos básicos con validaciones.
 */
public class Customer {
    private Long id;

    @NotBlank   // validación: no puede ser vacío
    private String name;

    @Email      // validación: formato email válido
    @NotBlank   // validación: no vacío
    private String email;

    // Constructor vacío
    public Customer() {
    }
    // Constructor con parámetros
    public Customer(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
