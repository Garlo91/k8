#!/usr/bin/env bash


cd api-seguros
./generaImagen.sh
cd ../

cd api-adm-autorizaciones
./generaImagen.sh
cd ../

cd api-empleados
./generaImagen.sh
cd ../

cd api-clientes
./generaImagen.sh
cd ../

cd api-creditos
./generaImagen.sh
cd ../

