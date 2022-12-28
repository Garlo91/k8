CREATE TABLE empleados (
  id      VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido_materno VARCHAR(255) NOT NULL,
  apellido_paterno VARCHAR(255) NOT NULL,
  edad Integer,
  curp VARCHAR(255) NOT NULL,
  rfc VARCHAR(255) NOT NULL,
  domicilio VARCHAR(1000) NOT NULL,
  imagen VARCHAR(255) NOT NULL,
  puesto  VARCHAR(255) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE,
  numero_empleado VARCHAR(255) NOT NULL
);
