# TechLogistics

Sistema de gestión de pedidos y rastreo de envíos desarrollado para
TechLogistics S.A.

Observación:

### Nota sobre la carpeta `target`

La carpeta `target` generada por Maven fue excluida del repositorio debido a su tamaño y a que contiene archivos compilados y temporales generados automáticamente durante la construcción del proyecto.

Estos archivos no son necesarios para ejecutar o revisar el código fuente, ya que Maven los genera nuevamente al realizar la compilación del proyecto.

Por esta razón, antes de subir el proyecto al repositorio se elimina la carpeta `target`. La aplicación puede reconstruirse utilizando Maven desde el archivo `pom.xml`.

## Tecnologías

- Java
- Spring Boot
- Maven
- JPA / Hibernate
- MariaDB
- XAMPP
- HTML, CSS y JavaScript
- NetBeans

## Requisitos

- Java 17 o superior
- Maven
- XAMPP
- MariaDB/MySQL

## Base de datos

Crear una base de datos llamada:

techlogistics

El proyecto utiliza:

- Servidor: localhost
- Puerto: 3306
- Usuario: root
- Contraseña: vacía

## Ejecución

1. Iniciar Apache y MySQL/MariaDB desde XAMPP.
2. Crear la base de datos `techlogistics`.
3. Abrir el proyecto en NetBeans.
4. Ejecutar el proyecto Spring Boot.
5. Abrir en el navegador:

http://localhost:8080

## Funcionalidades

- Consulta de clientes.
- Consulta de pedidos.
- Consulta de pedidos por ID.
- Rastreo de pedidos.
- Consulta de estado del envío.
- Consulta de transportista y ruta.

## API REST

### Clientes

GET /clientes

### Pedidos

GET /pedidos

GET /pedidos/{id}

POST /pedidos

### Productos

GET /productos

### Transportistas

GET /transportistas

### Rutas

GET /rutas

### Estados de envío

GET /estados-envio