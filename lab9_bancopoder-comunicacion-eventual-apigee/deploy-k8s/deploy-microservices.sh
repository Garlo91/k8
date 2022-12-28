#!/usr/bin/env bash

kubectl apply -f creditos;
kubectl apply -f adm-seguros;

kubectl apply -f empleados;
kubectl apply -f clientes;
kubectl apply -f seguros;