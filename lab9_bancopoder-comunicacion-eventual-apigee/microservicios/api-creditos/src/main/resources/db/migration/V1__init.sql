CREATE TABLE catalogos_referencias (
  id VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into catalogos_referencias(id, nombre, descripcion, estatus) VALUES(1,'companiero de trabajo','minimo 1 anio de conocer',true);
insert into catalogos_referencias(id, nombre, descripcion, estatus) VALUES(2,'familiar cercano','familiares cercanos a padres',true);

CREATE TABLE catalogos_productos (
 	id VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into catalogos_productos(id, nombre, descripcion, estatus) VALUES(1,'credito productos','credito para comprar online',true);
insert into catalogos_productos(id, nombre, descripcion, estatus) VALUES(2,'credito efectivo','dinero efectivo en MXN',true);
insert into catalogos_productos(id, nombre, descripcion, estatus) VALUES(3,'credito de auto','deposito directo a cuenta',true);


CREATE TABLE catalogos_estados (
	id VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into catalogos_estados(id, nombre, descripcion, estatus) VALUES(1,'mexico','distrito federal',true);
insert into catalogos_estados(id, nombre, descripcion, estatus) VALUES(2,'morelos','mexico morelos',true);
insert into catalogos_estados(id, nombre, descripcion, estatus) VALUES(3,'guerrero','mexico guerrero',true);
insert into catalogos_estados(id, nombre, descripcion, estatus) VALUES(4,'estado de mexico','estado de mexico',true);

CREATE TABLE catalogos_municipios (
	id VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into catalogos_municipios(id, nombre, descripcion, estatus) VALUES(1,'coyoacan','coyoacan',true);
insert into catalogos_municipios(id, nombre, descripcion, estatus) VALUES(2,'jiutepec','municipio en morelos',true);
insert into catalogos_municipios(id, nombre, descripcion, estatus) VALUES(3,'huautla','municipio en cuautla',true);
insert into catalogos_municipios(id, nombre, descripcion, estatus) VALUES(4,'ecatepec','municipio en edo de mexico',true);



CREATE TABLE catalogos_sucursal (
  id VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  telefono_sucursal VARCHAR(255) NOT NULL,
  id_estado_sucursal VARCHAR(255),
  id_municipio_sucursal VARCHAR(255),
  estatus BOOLEAN NOT NULL DEFAULT FALSE,
  FOREIGN KEY (id_estado_sucursal) REFERENCES catalogos_estados (id),
  FOREIGN KEY (id_municipio_sucursal) REFERENCES catalogos_municipios (id)
);

insert into catalogos_sucursal(id, nombre, descripcion, telefono_sucursal,id_estado_sucursal, id_municipio_sucursal, estatus) VALUES(100,'sucursal cdmx','sucursal en ciudad de mexico','5534545666',1,1,true);
insert into catalogos_sucursal(id, nombre, descripcion, telefono_sucursal,id_estado_sucursal, id_municipio_sucursal, estatus) VALUES(101,'sucursal estado de mexico','sucursal estado de mexico','5598765e3423',4,4,true);

CREATE TABLE catalogos_canales (
  id      VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into catalogos_canales(id, nombre, descripcion, estatus) VALUES(1001,'cajero','atm',true);
insert into catalogos_canales(id, nombre, descripcion, estatus) VALUES(1002,'sucursal','sucursales',true);
insert into catalogos_canales(id, nombre, descripcion, estatus) VALUES(1003,'web','sitio web',true);
insert into catalogos_canales(id, nombre, descripcion, estatus) VALUES(1004,'movil','aplicacion movil',true);


CREATE TABLE catalogos_paises (
  id      VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into catalogos_paises(id, nombre, descripcion, estatus) VALUES(1,'mexico','ciudad de mexico',true);
insert into catalogos_paises(id, nombre, descripcion, estatus) VALUES(2,'brasil','brasil',true);
insert into catalogos_paises(id, nombre, descripcion, estatus) VALUES(3,'morelos','estado de morelos',true);

CREATE TABLE conceptos_pago (
  id VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(500) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into conceptos_pago(id, nombre, descripcion, estatus) VALUES(1,'abono','aportaciones al credito',true);
insert into conceptos_pago(id, nombre, descripcion, estatus) VALUES(2,'retiro','descuento hacia el credito',true);
insert into conceptos_pago(id, nombre, descripcion, estatus) VALUES(3,'adelanto','pagos adelantados antes de fecha de pago',true);

CREATE TABLE creditos (
  id_credito VARCHAR(255) NOT NULL,
  id_cliente VARCHAR(255) NOT NULL,
  fecha  VARCHAR(255) NOT NULL,
  id_pais VARCHAR(255),
  id_canal VARCHAR(255),
  id_sucursal VARCHAR(255),
  id_producto VARCHAR(255),
  monto double precision DEFAULT NULL,
  plazo Integer,
  PRIMARY KEY(id_credito),
  FOREIGN KEY (id_producto) REFERENCES catalogos_productos (id),
  FOREIGN KEY (id_canal) REFERENCES catalogos_canales (id),
  FOREIGN KEY (id_pais) REFERENCES catalogos_paises (id),
  FOREIGN KEY (id_sucursal) REFERENCES catalogos_sucursal (id)
);


CREATE TABLE credito_referencias (
  id VARCHAR(255),
  id_credito VARCHAR(255) NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  apellidos VARCHAR(1000) NOT NULL,
  tipo_referencia VARCHAR(1000) NOT NULL,
  anios_conocimiento Integer,
  PRIMARY KEY(id, id_credito),
  FOREIGN KEY (id_credito) REFERENCES creditos (id_credito),
  FOREIGN KEY (tipo_referencia) REFERENCES catalogos_referencias (id)
);

CREATE TABLE credito_autorizaciones (
  id VARCHAR(255) ,
  id_credito VARCHAR(255) NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE,
  fecha VARCHAR(255) NOT NULL,
  fecha_confirmacion VARCHAR(255),
  PRIMARY KEY(id, id_credito),
  FOREIGN KEY (id_credito) REFERENCES creditos (id_credito)
);

CREATE TABLE credito_saldo (
  id VARCHAR(255) ,
  id_credito VARCHAR(255) NOT NULL,
  monto double precision DEFAULT NULL,
  monto_liquidacion double precision DEFAULT NULL,
  fecha_confirmacion VARCHAR(255) NOT NULL,
  PRIMARY KEY(id, id_credito),
  FOREIGN KEY (id_credito) REFERENCES creditos (id_credito)
);

CREATE TABLE credito_pagos (
  id VARCHAR(255),
  id_credito VARCHAR(255) NOT NULL,
  id_concepto VARCHAR(255) NOT NULL,
  importe double precision DEFAULT NULL,
  fecha VARCHAR(255) NOT NULL,
  PRIMARY KEY(id, id_credito),
  FOREIGN KEY (id_credito) REFERENCES creditos (id_credito),
  FOREIGN KEY (id_concepto) REFERENCES conceptos_pago (id)
);


		