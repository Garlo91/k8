CREATE TABLE seguros (
  id      VARCHAR(255) PRIMARY KEY,
  plazo double precision DEFAULT NULL,
  precio_poliza double precision DEFAULT NULL,
  tipo_cobertura Integer,
  vencimiento VARCHAR(1000) NOT NULL,
  suma_asegurada double precision DEFAULT NULL,
  nombre VARCHAR(255) NOT NULL,
  apellido_paterno VARCHAR(255) NOT NULL,
  apellido_materno VARCHAR(255) NOT NULL,
  fecha_nacimiento  VARCHAR(255) NOT NULL,
  sexo VARCHAR(255) NOT NULL,
  ingresos_anuales  double precision DEFAULT NULL,
  direccion VARCHAR(500) NOT NULL,
  autorizacion BOOLEAN DEFAULT FALSE
);

CREATE TABLE catalogo_seguros (
  id      VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into catalogo_seguros(id, nombre, descripcion, estatus) VALUES(1,'seguro-medico-juventud','seguro para personas entre 12 - 20',true);
insert into catalogo_seguros(id, nombre, descripcion, estatus) VALUES(2,'seguro-medico-mayor','seguro para personas entre 23 - 35',true);
insert into catalogo_seguros(id, nombre, descripcion, estatus) VALUES(3,'seguro-medico-infantil','seguro para personas entre 35 - 55',true);