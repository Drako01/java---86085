-- Comentario de 1 linea
/*
	Comentario de varias lineas    
*/

/*
Bloque 1: Introducción y Operaciones Básicas
	-----------------------------------------
	Crear una base de datos llamada tienda.
	Crear una tabla llamada productos con las siguientes columnas: id, nombre, precio, cantidad.
	Insertar 5 productos en la tabla productos.
	Consultar todos los productos de la tabla productos.
	Seleccionar los productos cuyo precio sea mayor a 100.
	Seleccionar el producto con el precio más bajo.
	Actualizar el precio de un producto.
	Eliminar un producto con precio menor a 50.
	Crear una tabla llamada clientes con columnas: id_cliente, nombre, email, telefono.
	Insertar 5 clientes en la tabla clientes.
	Consultar todos los clientes.
	Consultar el nombre y email de los clientes cuyo nombre empiece con "A".
	Actualizar el email de un cliente específico.
	Eliminar un cliente con un teléfono específico.
	Contar cuántos productos hay en la tabla productos.
*/

-- SQL Structured Query Lenguage

CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

CREATE TABLE productos (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    precio DECIMAL(10, 2),
    cantidad INT
);

INSERT INTO productos (nombre, precio, cantidad) VALUES 
	("Camara 2", 150.50, 30),
    ("Smartphone 2", 350.00, 50),
    ("Laptop 2", 800.50, 10),
    ("Tablet 2", 200.50, 25),
    ("Auriculares 2", 50.00, 100);

SELECT * FROM productos;

SELECT * FROM productos WHERE precio > 100;

SELECT * FROM productos ORDER BY precio ASC LIMIT 1;
-- SELECT * FROM productos ORDER BY precio DESC ;

SET SQL_SAFE_UPDATES = 0; -- Esto desactiva la proteccion de Update
UPDATE productos SET precio = 120 WHERE nombre = "Camara";
SET SQL_SAFE_UPDATES = 1; -- Esto activa la proteccion de Update

DELETE FROM productos WHERE precio < 55;

DROP TABLE clientes;
CREATE TABLE clientes (
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    email VARCHAR(150),
    telefono VARCHAR(15)
);

INSERT INTO clientes (nombre, email, telefono) VALUES
	("Juan Perez", "juan@mail.com", "12121212"),
    ("Marta Olivares", "marta@mail.com", "56565656"),
    ("Nico Molina", "nico@mail.com", "32354545"),
    ("Cielo Mangoni", "cielo@mail.com", "56852311"),
    ("Emi Quiñones", "emi@mail.com", "86263652");
    
SELECT * FROM clientes;

SELECT nombre, email FROM clientes WHERE nombre LIKE '%A';
SELECT nombre, email FROM clientes WHERE nombre LIKE '%A%';

DELETE FROM clientes WHERE telefono = "12121212";
SELECT COUNT(*) AS cantidad_productos FROM productos;

-- ------------------------------------------------------------
/*
Bloque 2: Filtrando y Ordenando Datos
-----------------------------------------
	Seleccionar todos los productos ordenados por precio de manera ascendente.
	Seleccionar todos los productos con un nombre que contenga la palabra "cámara".
	Contar cuántos productos tienen un precio mayor a 200.
	Calcular el precio promedio de los productos.
	Listar todos los productos que tienen más de 5 unidades en stock.
	Listar los productos que no tienen stock.
	Seleccionar los productos cuyo nombre sea "Cámara Digital" o "Smartphone".
	Listar los productos cuyo precio esté entre 50 y 200.
	Ordenar los productos por cantidad en stock de mayor a menor.
	Mostrar los primeros 3 productos más caros.
*/
/*
Bloque 3: Funciones Agregadas y Agrupamiento
---------------------------------------------
	Calcular el precio total de todos los productos.
	Encontrar el producto con el precio máximo.
	Encontrar el producto con el precio mínimo.
	Contar cuántos productos hay por cada precio.
	Calcular la suma de todos los precios de los productos con nombre "Cámara".
	Calcular el precio promedio de todos los productos.
	Agrupar los productos por nombre y contar cuántas veces aparece cada nombre.
	Agrupar los productos por su precio y contar cuántos productos hay en cada grupo.
	Calcular el promedio de precio de los productos de cada marca.
	Contar los productos con un precio mayor al promedio de todos los productos.
*/

SELECT SUM(precio) AS precio_total FROM productos;
-- Subconsultas SQL
SELECT * FROM productos WHERE precio = (SELECT MAX(precio) FROM productos);
SELECT * FROM productos WHERE precio = (SELECT MIN(precio) FROM productos);


SELECT precio, COUNT(*) AS cantidad FROM productos GROUP BY precio;

SELECT SUM(precio) AS precio_total FROM productos WHERE nombre LIKE 'Camara%';

SELECT AVG(precio) AS precio_promedio FROM productos;
SELECT ROUND(AVG(precio)) AS precio_promedio FROM productos;

SELECT nombre, COUNT(*) AS cantidad FROM productos GROUP BY nombre;

-- Agregar una columna llamada marca a productos
ALTER TABLE productos ADD COLUMN marca VARCHAR(50); -- Por defecto lo carga como NULL
ALTER TABLE productos ADD COLUMN marca VARCHAR(50) NOT NULL; -- Por defecto lo carga como NOT NULL (combiene usarla cuando la tabla esta vacia)
ALTER TABLE productos ADD COLUMN marca VARCHAR(50) DEFAULT 'Desconocida';

SELECT marca, ROUND(AVG(precio)) AS precio_promedio FROM productos GROUP BY marca;

 
 -- --------------------------------------------------
 
 /*
 Bloque 4: Relaciones y Subconsultas
 -------------------------------------
	Crear una tabla llamada ventas con las columnas: id_venta, id_cliente, id_producto, cantidad, fecha.
	Insertar 5 registros en la tabla ventas.
	Seleccionar las ventas realizadas por un cliente específico.
	Obtener el total gastado por cada cliente (usando la tabla ventas y la tabla productos).
	Obtener el total de ventas por producto (usando ventas y productos).
	Listar los productos que no se han vendido.
	Encontrar el cliente que ha comprado más productos.
	Mostrar el producto más vendido.
	Calcular el total de ventas de cada cliente.
	Obtener el total de ventas de cada producto en el último mes.
*/

CREATE TABLE ventas (
	id_venta INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    id_producto INT,
    cantidad INT,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);

SELECT * FROM productos;
SELECT * FROM clientes;
INSERT INTO ventas (id_cliente, id_producto, cantidad) VALUES
	(2, 1, 1), (3, 6, 4), (4, 2, 2), (5, 3, 6) , (2, 3, 20); 
    
SELECT * FROM ventas;

SELECT * FROM ventas WHERE id_cliente = 2;

-- Uso de JOINS
SELECT v.id_cliente, SUM(p.precio * v.cantidad) AS total_gastado
	FROM ventas v
    JOIN productos p ON v.id_producto = p.id
    GROUP BY v.id_cliente;

-- Productos que no se vendieron
SELECT id_producto FROM ventas;
SELECT * FROM productos WHERE id NOT IN (SELECT id_producto FROM ventas);


-- ---------------------------------------------------------

/*
Bloque 5: JOINS
------------------
	Realizar un INNER JOIN entre las tablas clientes y ventas para obtener los detalles de ventas por cliente.
	Realizar un LEFT JOIN entre las tablas clientes y ventas para mostrar todos los clientes y las ventas realizadas por ellos (si las hay).
	Realizar un RIGHT JOIN entre las tablas productos y ventas para obtener productos vendidos, incluyendo productos que no se hayan vendido.
	Usar un JOIN para obtener el nombre del cliente y el producto comprado en cada venta.
	Realizar un JOIN para obtener el total gastado por cada cliente, mostrando el nombre del cliente y la cantidad total gastada.
	Mostrar los productos que no han sido comprados, utilizando un LEFT JOIN.
	Obtener la lista de productos y clientes que han realizado una compra en común.
	Realizar un JOIN entre tres tablas: clientes, ventas, y productos para obtener un reporte completo de las compras realizadas.
	Realizar un SELF JOIN en la tabla productos para obtener productos que tengan un precio similar.
	Usar un FULL OUTER JOIN para combinar los registros de clientes y ventas.
*/

SELECT c.nombre, v.cantidad, p.nombre AS producto
	FROM clientes c
    INNER JOIN ventas v ON c.id_cliente = v.id_cliente
    INNER JOIN productos p ON v.id_producto = p.id;

SELECT c.nombre, v.cantidad, p.nombre AS producto
	FROM clientes c
    LEFT JOIN ventas v ON c.id_cliente = v.id_cliente
    LEFT JOIN productos p ON v.id_producto = p.id;

SELECT c.nombre, v.cantidad, p.nombre AS producto
	FROM clientes c
    RIGHT JOIN ventas v ON c.id_cliente = v.id_cliente
    RIGHT JOIN productos p ON v.id_producto = p.id;
    

SELECT c.nombre, v.cantidad, p.nombre AS producto
	FROM clientes c
    LEFT JOIN ventas v ON c.id_cliente = v.id_cliente
    LEFT JOIN productos p ON v.id_producto = p.id
	UNION
SELECT c.nombre, v.cantidad, p.nombre AS producto
	FROM clientes c
    RIGHT JOIN ventas v ON c.id_cliente = v.id_cliente
    RIGHT JOIN productos p ON v.id_producto = p.id;

-- Usar un JOIN para obtener el nombre del cliente y el producto comprado en cada venta.
SELECT c.nombre AS cliente, p.nombre AS producto
	FROM clientes c
    JOIN ventas v ON c.id_cliente = v.id_cliente
    JOIN productos p ON v.id_producto = p.id;
    
-- Realizar un JOIN para obtener el total gastado por cada cliente, mostrando el nombre del cliente y la cantidad total gastada.
SELECT c.nombre, SUM(p.precio * v.cantidad) AS total_gastado
	FROM clientes c
    JOIN ventas v ON c.id_cliente = v.id_cliente
    JOIN productos p ON v.id_cliente = p.id
    GROUP BY c.nombre;

-- Mostrar los productos que no han sido comprados, utilizando un LEFT JOIN.
SELECT p.nombre
	FROM productos p
	LEFT JOIN ventas v ON p.id = v.id_producto
    WHERE v.id_producto IS NULL;