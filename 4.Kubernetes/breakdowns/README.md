
## Command for working with pod 
What is POD? 
POD is a smallest deployable unit inside Kubenetes 
Inside the pods there can be 1 or more containers , typically more container of the same images, but normally one container per pod. 
```yaml
apiVersion: v1 
kind: Pod 
metadata: 
    name: nginx-pod 
spec: 
    containers: 
        - name: nginx-pod
          image: nginx:latest 
          ports: 
            - containerPort: 80 
```


```bash
kubectl api-resource 

kubectl apply -f nginx-pod.yaml 
kubectl logs -f nginx-pod 
kubectl delete pod nginx-pod 

# list all the contaiers 
kubectl get pod nginx-pod \
    -o jsonpath='{.spec.containers[*].name}'


# say you dn't have access to nginx-pod.yaml 
kubectl describe pod nginx-pod
# if you want to login to the container shell  
kubectl exec -it nginx-pod -- bash 

```
**RBAC**
Rolebased access control ( Kubeneretes Admin )
`ns = projectA` 
`ns = projectB `
Role for different namespace 



## REPLICASET 
create rs  = auto create pod 
replicaset , ensure the number of pod willbe running, if you delete it , it will recreate or restart when failure happen

