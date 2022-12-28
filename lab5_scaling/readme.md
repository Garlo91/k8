Kubernetes permite definir una politica para
permitir escalado horizontal automatico

• La métrica que se utiliza es consumo de CPU.
• Se permiten métricas personalizadas, pero cada instalación es responsible de generarlas.
• Heapster debe estar activado para que funcione
correctamente.
• Revisar la configuración del controller-manager para detalles
de la metrica.


kubectl get deployments
-----------------------------------------------------------------------------------

pasos a seguir:

1.- cd api-clientes

2.- gradle buildImage

3.- hacer docker push

4.- $ kubectl apply -f kubernetes 

5.- cd api-creditos

6.- gradle buildImage

7.- hacer docker push

8.- $ kubectl apply -f kubernetes

9.- estresando el backend para subir el consumo de memoria

ciclo infinito para estresar el backend

while true; do sleep 0; curl --location --request GET '34.70.142.35:8081/api/v1/clientes/231748491'; echo -e '\n\n\n\n'$(date);done


10.- wrk -t1 -c1 -d3000s http://34.68.252.120:8081/api/v1/clientes

11.- validar el consumo actual del HPA 

12.- $ kubectl get pods,svc,pv,pvc,hpa --all-namespaces 

13-.-El HPA vía Heapster comienza a actualiza el uso de CPU.

14.- El targer indica que ya sobrepaso del ?

while true; do sleep 0; curl --location --request POST '34.134.216.18:8081/api/v1/creditos' --header 'Content-Type: application/json' --data-raw '{
    "montoCredito":200.0,
   "folioCliente":"ljdlkd"
}'; echo -e '\n\n\n\n'$(date);done

15.- wrk -t100 -c100 -d300s http://34.134.216.18:8081/api/v1/creditos

16.- Se crean REPLICAS y tenemos 10 PODs, atendiendo cada solicitud de forma balanceada.

detener todo y hacer scaling down