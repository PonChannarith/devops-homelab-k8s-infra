## When configuring the domain name for the service with nginx 


1. /etc/nginx/conf.d 
each file must used extension .conf 


2. `/etc/nginx/site-availables`
    sonarqube-sc.anajak-khmer.site (filename )
    - after wrting configuratio file , we will need link it to `site-enabled` 
3. `/etc/nginx/site-enabled` 



*** 


1. Jenkins need credentials(username, password) on sonaruqbe to create and store the project inside sonarqube server 
username: admin 
password: token-that-we-generate

- Setup credential inside jenkins 

2. In jenkins pipeline , specific sonaruqbe with the credentials to scan the project 

```bash
stage("Check Code Quality in Sonarqube "){
            
            environment {
                scannerHome= tool 'sonar-scanner' 
            }

            steps{
                withSonarQubeEnv(credentialsId: 'SONARQUBE_TOKEN', installationName: 'sonarqube-scanner') {
                script{
                
                    def projectKey = 'reactjs-devops11-template' 
                    def projectName = 'ReactjsDevOps11template'
                    def projectVersion = '1.0.0' 
                    sh """
                    ${scannerHome}/bin/sonar-scanner \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.projectName="${projectName}" \
                    -Dsonar.projectVersion=${projectVersion} \
                     """   
                        
                        }
            }

            }
        }

```
