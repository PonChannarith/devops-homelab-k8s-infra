// This one is working 

pipeline {
    agent any

    stages {

        stage('Clone Code ') {
            steps {
                git 'https://github.com/keoKAY/reactjs-devop11-template.git'
            }
        }

        stage('OWASP Dependency Check') {
            steps {

                sh '''
                    /opt/dependency-check/bin/dependency-check.sh \
                      --project "ReactJS App" \
                      --scan . \
                      --format HTML \
                      --format XML \
                      --out reports \
                      --data /var/lib/jenkins/odc-data \
                      --disableAssembly
                '''
            }
        }

stage('Publish Dependency Report') {
    steps {

        dependencyCheckPublisher(
            pattern: 'reports/dependency-check-report.xml',
            unstableTotalHigh: 1,
            unstableTotalCritical: 1
        )

        publishHTML(target: [
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'reports',
            reportFiles: 'dependency-check-report.html',
            reportName: 'OWASP Dependency Check Report'
        ])
    }
}
        // stage('Publish Dependency Report') {
        //     when {
        //         expression {
                    
        //         }
        //     }
        //     steps {
        //         publishHTML([
        //             allowMissing: false,
        //             alwaysLinkToLastBuild: true,
        //             keepAll: true,
        //             reportDir: 'reports',
        //             reportFiles: 'dependency-check-report.html',
        //             reportName: 'OWASP Dependency Check Report'
        //         ])
        //     }
        // }

        stage('Building Image') {
            steps {
                sh """
                docker build -t reactjs-demo-image .
                """
            }
        }
    }
    post {
    always {
        archiveArtifacts artifacts: 'reports/*.html', fingerprint: true
    }
}
}