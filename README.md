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
