#!/usr/bin/env bash

kubectl apply -f postgrest-k8s/postgres-database-dep.yml;
kubectl apply -f postgrest-k8s/postgres-database-svc.yml;