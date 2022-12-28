gcloud container clusters get-credentials standard-cluster-6 --zone us-central1-a --project api-project-47298316825


kubectl cluster-info

kubectl create clusterrolebinding cluster-admin-binding \
    --clusterrole=cluster-admin \
    --user=$(gcloud config get-value core/account)



kubectl get pods,svc --all-namespaces


 kubectl get svc -n istio-system


 kubectl label namespace default istio-injection=enabled

 kubectl get namespace -L istio-injection


las nuevas versiones de istio, dejaron atras el uso de Ingress, y ahora debemos configurar el siguiente Gateway para manejar el punto de entrada para nuestras solicitudes y estás redireccionarlas al ingressgateway

apiVersion: networking.istio.io/v1alpha3
kind: Gateway
metadata:
  name: istio-gateway
spec:
  selector:
    istio: ingressgateway # use istio default controller
  servers:
  - port:
      number: 80
      name: http
      protocol: HTTP
    hosts:
    - "*"

microservicios-virtualservices.yml, Aqui se configuran las rutas para el tráfico que ingresa a través del Gateway:

apiVersion: networking.istio.io/v1alpha3
kind: VirtualService
metadata:
  name: microservicios-gateway-vs
spec:
  hosts:
  - "*"
  gateways:
  - istio-gateway
  http:
  - match:
    - uri:
        prefix: /api/v1/clientes
    route:
    - destination:
        host: servicio-cliente
  - match:
    - uri:
        prefix: /api/v1/creditos
    route:
    - destination:
        host: servicio-creditos


kubectl apply -f istio-gateway.yml
kubectl apply -f microservicios-virtualservices.yml


Deploy y Services de MicroServicios

apiVersion: extensions/v1beta1
kind: Deployment
metadata:
 name: servicio-cliente
 labels:
 app: servicio-cliente
spec:
 selector:
 matchLabels:
 app: servicio-cliente
 template:
 metadata:
 labels:
 app: servicio-cliente
 spec:
 containers:
 — name: servicio-cliente
 image: jovaniac/servicio-cliente:0.0.1-snapshot
 ports:
 — containerPort: 8081
 protocol: TCP


 apiVersion: v1
kind: Service
metadata:
  name: servicio-cliente
  labels:
    app: servicio-cliente
spec:
  ports:
  - port: 8081
    name: http
  selector:
    app: servicio-cliente


kubectl apply -f kubernetes/


Deploy de Cŕeditos:

apiVersion: extensions/v1beta1
kind: Deployment
metadata:
 name: servicio-creditos
 labels:
 app: servicio-creditos
spec:
 selector:
 matchLabels:
 app: servicio-creditos
 template:
 metadata:
 labels:
 app: servicio-creditos
 spec:
 containers:
 — name: servicio-creditos
 image: jovaniac/servicio-creditos:0.0.1-snapshot
 ports:
 — containerPort: 8081
 protocol: TCP

apiVersion: v1
kind: Service
metadata:
  name: servicio-creditos
  labels:
    app: servicio-creditos
spec:
  ports:
  - port: 8081
    name: http
  selector:
    app: servicio-creditos


kubectl apply -f kubernetes/

kubectl get svc istio-ingressgateway -n istio-system


istio-system service/istio-ingressgateway LoadBalancer 10.15.250.106 146.148.44.109 80:31380/TCP,443:31390/TCP,31400:31400/TCP

Podemos ver el pueto 80 mapeado al exterior por el 31380 y modo seguro 31390.

Request a clientes:

http://146.148.44.109:31380/api/v1/clientes

Payload de entrada:

{
 “apellidoMaterno”: “cabrera”,
 “apellidoPaterno”: “arzate”,
 “direccion”: “test”,
 “edad”: 29,
 “email”: “jovaniac@gmail.com”,
 “genero”: “h”,
 “nombre”: “jovani”
}

Respuesta, vemos que genera un folio de creación del cliente.

{
 “folioCliente”: “-193107644”,
 “nombre”: “jovani”,
 “apellidoPaterno”: “arzate”,
 “apellidoMaterno”: “cabrera”,
 “email”: “jovaniac@gmail.com”,
 “direccion”: “test”,
 “genero”: “h”,
 “edad”: 29
}


kubectl logs -f servicio-cliente-6489c6674c-nv6qt -n default servicio-cliente


Request al microservicio de Clientes, este a su vez invoca el microservicio de Créditos.

{
 "montoCredito": "4500",
 "folioCliente":"1431734275"
}

http://146.148.44.109:31380/api/v1/clientes/1431734275/creditos

{
    "folioCredito": "-1889995241",
    "montoDeuda": 4500,
    "folioCliente": "1431734275"
}

kubectl port-forward -n istio-system $(kubectl get pod -n istio-system -l app=jaeger -o jsonpath='{.items[0].metadata.name}') 16686:16686 &


Ahora accedemos a

http://localhost:16686/search

Seleccionamos el microservicio de Clientes y le damos en Find Traces.

Nos aparece toda la información de las solicitues que se han realizado a travéz del tiempo, así como cado uno de los request realizados.