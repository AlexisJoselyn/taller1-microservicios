📦 Product API + MongoDB

Este proyecto demuestra cómo realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos utilizando MongoDB como base de datos.

🚀 Levantar MongoDB

Para conectarte a la base de datos:

mongosh "mongodb://localhost:27017/productdb"

📂 Consultar colecciones en MongoDB
use productsdb
show collections
db.products.find().pretty()

🔗 Endpoints principales
Método	Endpoint	Descripción
POST	/products	Registrar un nuevo producto
GET	/products	Listar todos los productos
GET	/products/{id}	Consultar producto por ID
PUT	/products/{id}	Actualizar un producto existente
PATCH	/products/{id}/stock	Agregar stock
POST	/products/{id}/buy	Comprar producto
DELETE	/products/{id}	Eliminar producto
📝 Funcionalidades

1️⃣ Registrar producto

Ejemplo de registro desde Postman:

<img width="700" alt="Registrar producto" src="https://github.com/user-attachments/assets/3d0c36f6-d6cb-4e34-b797-7699c222ed01" />

Resultado en MongoDB:

<img width="700" alt="Producto registrado en MongoDB" src="https://github.com/user-attachments/assets/d1790402-9223-4675-9f5c-a0d7030e2804" />

2️⃣ Actualizar producto

<img width="700" alt="Actualizar producto" src="https://github.com/user-attachments/assets/0382d014-7bff-4996-aa5a-03d9bd766a35" />

Consulta en MongoDB:

<img width="700" alt="Producto actualizado en MongoDB" src="https://github.com/user-attachments/assets/e0edba75-d817-4147-9e6c-c218584f4c71" />

3️⃣ Agregar stock

<img width="700" alt="Agregar stock" src="https://github.com/user-attachments/assets/a77d4d88-bc68-458d-8108-686032736b88" />

Validación en MongoDB:

<img width="700" alt="Stock actualizado en MongoDB" src="https://github.com/user-attachments/assets/386ff27c-16b2-410e-a63d-167a3d64ca72" />

4️⃣ Comprar producto

<img width="700" alt="Comprar producto" src="https://github.com/user-attachments/assets/0bee718a-b078-4693-b4da-63cfcda472db" />

Consulta en MongoDB:

<img width="700" alt="Producto comprado en MongoDB" src="https://github.com/user-attachments/assets/2bc1b6db-0238-4cd7-8f96-711072144211" />

5️⃣ Eliminar producto

<img width="700" alt="Eliminar producto" src="https://github.com/user-attachments/assets/03866472-d0e5-4fae-87ab-c41fc98fcb85" />

Validación en MongoDB:

<img width="700" alt="Producto eliminado en MongoDB" src="https://github.com/user-attachments/assets/dc162d1d-09cf-41f4-bfd2-819540c8cad7" />

✅ Conclusión

Con este flujo puedes:

Registrar productos en la BD

Actualizar información existente

Agregar stock

Comprar productos (descontar stock)

Eliminar registros

# 📘 Documentación del Proyecto

## 1. Definiciones y especificación de requerimientos

### a) Definición general del proyecto
- **Idea general:** Microservicio en **Spring Boot 3** que permite gestionar productos mediante operaciones CRUD y funcionalidades adicionales como agregar stock y registrar compras.  
- **Objetivo:** Implementar un servicio REST para la administración de productos almacenados en **MongoDB**, siguiendo buenas prácticas de desarrollo (validaciones, cobertura de pruebas, documentación automática con Swagger/OpenAPI).  
- **Usuarios:**  
  - Desarrolladores de software que necesiten extender o integrar el microservicio.  
  - Usuarios de negocio que interactúen con la API a través de un cliente (Postman, front-end, etc.).  

### b) Especificación de requerimientos
- **Requisitos generales:**  
  - Framework: Spring Boot 3.5.5  
  - Lenguaje: Java 17  
  - Base de datos: MongoDB  
  - Documentación de API: Swagger UI (springdoc-openapi)  
  - Validaciones con `spring-boot-starter-validation`  
  - Pruebas unitarias con JUnit 5 y JaCoCo  

- **Requisitos funcionales:**  
  - Crear, leer, actualizar y eliminar productos.  
  - Actualizar stock.  
  - Comprar producto (descontar stock).  

- **Alcances y limitaciones:**  
  - El microservicio no incluye autenticación ni gestión de usuarios.  
  - Se centra únicamente en la gestión de productos.  

### c) Procedimientos de instalación y prueba
- **Instalación:**  
  1. Clonar el repositorio:  
     ```bash
     git clone https://github.com/AlexisJoselyn/taller1-microservicios.git
     cd taller1-microservicios
     ```
  2. Levantar una instancia de **MongoDB** local o en contenedor Docker.  
  3. Compilar y ejecutar:  
     ```bash
     mvn clean install
     mvn spring-boot:run
     ```

- **Pruebas:**  
  - Ejecutar con:  
    ```bash
    mvn test
    ```

---

## 2. Arquitectura del sistema
- **Descripción jerárquica:** Proyecto organizado en capas bajo el estándar de Spring Boot:  
  - `api`: interfaces generadas con OpenAPI.  
  - `model`: modelos de datos de productos.  
  - `controller`: controladores REST.  
  - `repository`: acceso a MongoDB.  
  - `service`: lógica de negocio.  

- **Dependencias externas:**  
  - Spring Boot Web, Validation, MongoDB.  
  - Lombok para reducir boilerplate.  
  - Springdoc OpenAPI para documentación.  

---

## 3. Diseño del modelo de datos
- **Entidad principal: `Product`**  
  - `id`: identificador único.  
  - `name`: nombre del producto.  
  - `price`: precio unitario.  
  - `stock`: cantidad disponible.  

---

## 4. Descripción de procesos y servicios
- **Servicios principales (endpoints):**  
  - `POST /products` → registrar producto.  
  - `GET /products` → listar productos.  
  - `GET /products/{id}` → consultar producto por ID.  
  - `PUT /products/{id}` → actualizar producto.  
  - `PATCH /products/{id}/stock` → incrementar stock.  
  - `POST /products/{id}/buy` → comprar producto (descontar stock).  
  - `DELETE /products/{id}` → eliminar producto.  

---

## 5. Documentación técnica - Especificación API
- **Swagger UI** disponible en:  
  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  

- **Esquema OpenAPI** en:  
  `src/main/resources/openapi/products.yaml`  

- **Herramientas de soporte:**  
  - Generación de código de interfaces con `openapi-generator-maven-plugin`.  
  - Validaciones automáticas con `spring-boot-starter-validation`.  

### 📌 Endpoints principales

| Método HTTP | Ruta                   | Descripción                        |
|-------------|------------------------|------------------------------------|
| POST        | `/products`            | Registrar un nuevo producto        |
| GET         | `/products`            | Listar todos los productos         |
| GET         | `/products/{id}`       | Consultar producto por ID          |
| PUT         | `/products/{id}`       | Actualizar producto                |
| PATCH       | `/products/{id}/stock` | Agregar stock                      |
| POST        | `/products/{id}/buy`   | Comprar producto (descontar stock) |
| DELETE      | `/products/{id}`       | Eliminar producto                  |

---

