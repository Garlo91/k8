#!/usr/bin/env bash

kubectl delete -f deploy-infra-db;
kubectl delete -f postgrest-k8s;

