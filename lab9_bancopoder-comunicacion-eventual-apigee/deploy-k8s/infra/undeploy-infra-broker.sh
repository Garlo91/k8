#!/usr/bin/env bash

kubectl delete -f deploy-infra-broker/broker-dev.yaml;
kubectl delete -f deploy-infra-broker/broker-svc.yaml;