
Las replicas de un pod, permiten que podamos
escalar horizontalmente como lo necesitemos y los
recursos que tengamos disponibles.

Kubernetes mediante los servicios, permite distribuir el tráfico en los diferentes
replicas del POD

Services:

Lo que hacen es crear un punto de entrada que
recibe el tráfico por el puerto definido y balanca
entre las distintas replicas del pod. (kube-proxy)

• El algoritmo de balanceo es RoundRobin 

Logs de los contenedores

kubectl logs {nombre_pod} {nombre_container}

– El {nombre_container} es opcional cuando el pod
solo tiene un solo contenedor

• El flag -f es util para “seguir” los cambios en el log
(follow)

• kubectl logs -f {nombre_pod} {nombre_container}


Pasos a seguir para el ejercicio:

$ cd api-clientes-microservicios 

$ gradle buildImage

$ docker push nombre-imagen

$ kubectl apply -f kubernetes

Entrar a cada uno de los logs

kubectl logs -f <pod> -n default portalweb

wrk -t1 -c1 -d310s http://334.134.143.219:8081/api/v1/clientes

while true; do sleep 0; curl --location --request POST '34.134.143.219:8081/api/v1/clientes' \
--header 'Content-Type: application/json' \
--data-raw '{
 "apellidoMaterno": "cabrera",
 "apellidoPaterno": "arzate",
 "direccion": "test",
 "edad": 29,
 "email": "jovaniac@gmail.com",
 "genero": "h",
 "nombre": "jovani"
}'; echo -e '\n\n\n\n'$(date);done

while true; do sleep 0; curl --location --request GET 'http://34.134.143.219:8084/reportes/v1/2021' \
--data-raw ''; echo -e '\n\n\n\n'$(date);done


kubectl delete pod servicio-cliente-545545784c-v7xdb
