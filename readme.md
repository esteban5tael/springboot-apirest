# ApiRest Project

Este proyecto es una API REST construida con Spring Boot, diseñada para gestionar productos. Utiliza Spring Data JPA para interactuar con una base de datos PostgreSQL y ofrece un conjunto de endpoints para realizar operaciones CRUD sobre los productos.


## Características del Entity `Product`

El entity `Product` representa los productos en la base de datos y tiene las siguientes propiedades:

- `id`: Un identificador único para cada producto (Long).
- `name`: El nombre del producto (String). Debe ser único.
- `price`: El precio del producto (double).
- `quantity`: La cantidad disponible del producto (int).

## Endpoints

La API expone los siguientes endpoints para interactuar con los productos:

- `GET /api/v1/products`: Obtiene una lista de todos los productos.
- `GET /api/v1/products/{id}`: Obtiene un producto específico por su ID.
- `POST /api/v1/products`: Crea un nuevo producto.
- `PATCH /api/v1/products/{id}`: Actualiza los detalles de un producto existente.
- `DELETE /api/v1/products/{id}`: Elimina un producto por su ID.

Todos los endpoints soportan Cross-Origin Requests (CORS).