pipeline {
    // any agent available to run it , run it 
    agent any
 
    stages {
        stage('Clone Code ') {
            steps {
                git 'https://github.com/keoKAY/reactjs-devop11-template.git'
            
            }
        }
      
        stage('OWASP Dependency Check') {
            steps {
                // Run the scan
                dependencyCheck odcInstallation: 'dependencies-check', additionalArguments: '--scan "./"'
                
                // Publish the report to the Jenkins UI
                dependencyCheckPublisher pattern: 'target/dependency-check-report.xml'
            }
}
        stage('Building Image') {
            steps {
                sh """
                docker build -t reactjs-demo-image  . 
                """
            }
        }

      
       
    }
}
