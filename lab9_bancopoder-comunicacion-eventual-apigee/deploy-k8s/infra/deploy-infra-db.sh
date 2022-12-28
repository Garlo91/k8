#!/usr/bin/env bash

kubectl apply -f deploy-infra-db/postgres-pv.yml;
kubectl apply -f deploy-infra-db/postgres-pvc.yml;