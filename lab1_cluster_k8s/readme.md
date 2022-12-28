1.- instalar gcloud:

sudo snap install google-cloud-sdk --classic
gcloud version

autenticación:

1.- gcloud auth login

configuración del proyecto:

2.- gcloud config set project sincere-surfer-328722 
3.- gcloud config set compute/zone us-central1-a  compute-zone

4.- instalar kubectl

Kubectl es la herramienta cliente para interactuar con el API REST de Kubernetes. Funciona en la terminal (shell) de todos los sistemas operativos.

https://kubernetes.io/docs/tasks/tools/install-kubectl/

5.- sudo snap install kubectl --classic

6.- kubectl version

Conectando a un cluster de K8S, crear Cluster en GCP 
elegir 1.14.10 version

Esto lo podemos copiar de la consola de GCP

7.- gcloud container clusters get-credentials standard-cluster-1 --zone us-central1-a --project api-project-47298316825

crear cluster estandar:

8.- cat config /home/jovani/.kube/config

validar información del cluster:

9.- kubectl cluster-info

Indica numero de nodos del cluter:

kubectl get pods
kubectl get pods --all-namespaces

desplegar Deployment: Una implementación proporciona actualizaciones declarativas para Pods y ReplicaSets.

10.- kubectl create deployment hello-server --image=gcr.io/google-samples/hello-app:1.0

No puedo acceder al pod a menos que lo exponga!!!

Lo que hará el comando anterior es crear un `Deployment`, 

El solo hecho de hacer el despliegue no garantiza que el contenedores pueda ser `descubierto` por los demás contenedores dentro del cluster y mucho menos por otros procesos externos del cluster. 

El Deployment por ahora solo hace la ejecución del contenedor sin exponer ningún puerto dentro y fuera del cluster.

11.- descubrir deploy:

kubectl expose deployment hello-server --type LoadBalancer --port 80 --target-port 8080

Consultar servicios:
kubectl get service hello-server

Validar exposición:
http://externalIP:80/


tratar de eliminar el pod:
kubectl delete pod hello-server-7f8fd4d44b-286g9

eliminar deployment:
kubectl delete deployment hello-server

eliminar service:
kubectl delete service hello-server


kubectl create deployment --image nginx nginx-1
kubectl expose pod $my_nginx_pod --port 80 --type LoadBalancer
kubectl exec -it new-nginx /bin/bash
    apt-get update
    apt-get install nano

    cd /usr/share/nginx/html
    nano test.html
kubectl logs new-nginx -f --timestamps
