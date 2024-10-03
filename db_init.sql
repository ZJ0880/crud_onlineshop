CREATE DATABASE TiendaOnline;

USE TiendaOnline;

CREATE TABLE Productos (
  id_producto INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  descripcion TEXT,
  precio DECIMAL(10, 2),
  stock INT,
  fecha_agregado DATE
);
