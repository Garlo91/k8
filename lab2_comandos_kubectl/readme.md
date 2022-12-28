
## Desplegar la aplicación en GKE, previo generar imagen docker

$ cd serverjs

construimos imagen:
$ docker build -t ibracoder/server-app:0.1 .

subimos imagen a el registry de dockerhub:

$ docker push ibracoder/server-app:0.1

Desplegamos el pod en kubernetes, primeramente hace pull de la imagen:

    kubectl create deployment server-app --image=ibracoder/server-app:0.1 --port=5000
  ---$ kubectl run server-app --image=ibracoder/server-app:0.1 --port=5000

    kubectl expose deploy  server-app --type LoadBalancer --port 8080 --target-port 5000
  ----$ kubectl expose pod server-app --type LoadBalancer --port 8080 --target-port 5000

Desplegamos por manifiestos en kubernetes:

  $ kubectl apply -f k8s

kubectl create
– Siempre intentará crear el recurso que se le indique, fallará
si ya existe.

• kubectl patch
– Hará actualizaciones parciales, util cuando el recurso ya
existe y queremos actualizarlo

• kubectl apply
– Internamente decidirá si es necesario crear el recurso o si es
solo necesario aplicar una actualización parcial.
"Es el recomendado"

• kubectl delete
– Elimina el recurso del cluster

kubectl get svc --all-namespaces


http://externalIP:5000/

## Describir componentes:

kubectl describe pod server-app-fd776796b-pkkgs

## Verificar que esta corriendo

  $ kubectl get pods

NAME                         READY   STATUS    RESTARTS   AGE
server-app-fd776796b-pkkgs   1/1     Running   0          2m8s

Importante es revisar el `STATUS`.

*IMPORTANTE*: Cada linea de la salida anterior, representa una instancia de algún pod. A esta instancia se le conoce como `Replica`. Lo que significa que, podemos crear varias replicas de un mismo pod para escalar horizontalmente.

kubectl get pods
– Obtiene todos los pods
• kubectl get pods ${nombre_pod}

– Obtiene los detalles de un pod particular en YAML / JSON

• kubectl get pods ${nombre_pod} -o yaml
• kubectl get pods ${nombre_pod} -o json

## Exponer puertos

Para exponer los puertos, se usan los `Services`. De estos hay de muchos tipos, por ahora haremos uno muy sencillo.

## Ver los distintos servicios que tiene mi cluster

  $ kubectl get services
  $ kubectl get svc

## Obtener una descripción detallada de los services

  $ kubectl describe service server-app

## Forward de puertos

En ocasiones es útil hacer redirección de puertos de forma temporal para acceder a un puerto de un pod. Esto para evitar crear un servicio. La forma en que funciona es: `kubectl port-forward ${nombre_pod} ${puerto_local}:${puerto_contenedor}`

Suponiendo que el nombre del pod de la aplicacion `server-app` es `server-app-45676543`, con la siguiente instrucción el tráfico de la maquina local en el puerto `5000` se va a redirigir al puerto `8080` del contenedor que corre en Kubernetes.

  Eliminar el service creado anteriormente y acceder por port-forward
  $ kubectl delete service nombre-service

  $ kubectl port-forward idPOD 8080:5000

## Borrar Pods y services

Se puede eliminar la configuración con el comando `kubectl delete ${recurso} {nombre_recurso}`

  $ kubectl get pods,deployment,svc --all-namespaces


  $ kubectl delete service server-app
  $ kubectl delete deployment server-app

  al eliminar el deployment eliminamos la definicion del POD:
  
  $ kubectl delete pod server-app

