#!/usr/bin/env bash

kubectl delete -f clientes;
kubectl delete -f empleados;
kubectl delete -f creditos;
kubectl delete -f seguros;
kubectl delete -f adm-seguros;