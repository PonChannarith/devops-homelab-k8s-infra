## HELM intro 


1. deployment 
2. service 
3. ingress 
4. pv/pvc 



nginx-chart 
spring-chart 
reactjs-chart 



helm install nginx-release nginx-chart 


## basic command with helm 
1. Create nginx chart 

```bash 
helm create nginx-chart 

# preview the configuration 
helm template nginx-chart 
helm template nginx-chart --values prod-value.yaml 

# first release 
helm install nginx-release nginx-chart 
helm list # to see all the release 
helm uninstall nginx-release # nginx-release (release name )



# after modified the values from of your chart 
helm upgrade nignx-release nginx-chart --values nginx-chart/prod-values.yaml 

helm history nginx-release 
helm rollback nginx-release <revision1> 

# In order to store helm efficiently 
helm package nginx-chart 
# Create a release (deploy svc ) from the zip file 
helm install nginx-release zip-file 

helm repo add chart-name URL 
helm repo remove chart-name 

```
- Understand the file structure  

*** 
## Create our own chart from scratch 

```bash 
helm create customized-chart 

```
