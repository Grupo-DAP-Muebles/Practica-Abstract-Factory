# Practica-Abstract-Factory

Repositorio creado para la práctica 5 de la asignatura **Diseño Arquitectónico y Patrones**.

Este repositorio incluye una implementación de la práctica sobre el patrón **Abstract Factory** junto con una **API de muebles** desarrollada en **Spring Boot**.

## API de Muebles

La API de muebles permite acceder a una lista de muebles organizada por categorías, como sillas, mesas y sofás. Los datos están estructurados en formato JSON y son accesibles mediante un endpoint RESTful.

### Funcionalidad de la API

- **Endpoint**: `GET /api/muebles`
- **Descripción**: Devuelve un JSON con una lista de muebles clasificados en categorías.
- **Categorías incluidas**:
  - **Sillas**: Una colección de sillas con sus respectivos nombres, precios e identificadores.
  - **Mesas**: Una colección de mesas con sus respectivos nombres, precios e identificadores.
  - **Sofás**: Una colección de sofás con sus respectivos nombres, precios e identificadores.

### Ejemplo de Respuesta JSON

```json
{
    "sillas": [
        { "id": "3", "nombre": "Silla Modelo1", "precio": 90.99, "categoria": "silla" }
    ],
    "sofás": [
        { "id": "1", "nombre": "Sofá Modelo2", "precio": 299.99, "categoria": "sofá" }
    ],
    "mesas": [
        { "id": "2", "nombre": "Mesa Modelo3", "precio": 49.99, "categoria": "mesa" }
    ]
}
