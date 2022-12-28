CREATE TABLE autorizaciones (
  id_autorizacion      VARCHAR(255) PRIMARY KEY,
  datos_poliza  VARCHAR NOT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE,
  fecha_apertura VARCHAR,
  fecha_confirmacion VARCHAR
);

