pipeline {
    agent any

    // user run the pipeline = jenkins 
    


    stages {
        stage('Clone Code') {
            steps {
                echo 'Hello World'
            }
        }

         stage('Build Image') {
            steps {
                echo 'Building Images'
            }
        }

        stage('Deploy on Testing Server') {
            // Ansible playbook to run the container inside different server 
            steps {
                echo 'Deploy on different '
            }
        }
    }
}
