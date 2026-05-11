pipeline {
    agent any

    environment {
        NVD_API_KEY = credentials('nvd-api-key')
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/keoKAY/reactjs-devop11-template.git'
            
            }
        }

        stage('Dependency Vulnerability Scan') {
    steps {

        withCredentials([
            string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')
        ]) {

            dependencyCheck(
                odcInstallation: 'dependencies-check',
                additionalArguments: '''
                    --scan . \
                    --format ALL \
                    --nvdApiKey $NVD_API_KEY
                '''
            )
        }
    }
}

        stage('Publish Report') {
            steps {
                dependencyCheckPublisher(
                    pattern: '**/dependency-check-report.xml',
                    failedTotalHigh: 1,
                    failedTotalCritical: 1
                )
            }
        }
    }
}