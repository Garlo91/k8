#!/usr/bin/env bash

kubectl apply -f deploy-infra-broker/broker-dev.yaml;
kubectl apply -f deploy-infra-broker/broker-svc.yaml;