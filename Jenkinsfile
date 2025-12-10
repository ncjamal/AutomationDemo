pipeline {
    agent any

    tools {
        maven 'M3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    parallel(
                        "Chrome (headless)" : {
                            bat 'mvn clean test -Dheadless=true -Dbrowser=chrome'
                        },
                        "Firefox (headless)" : {
                            bat 'mvn clean test -Dheadless=true -Dbrowser=firefox'
                        }
                    )
                }
            }
        }

    post {
        always {
            archiveArtifacts artifacts: 'test-output/**'
            publishHTML(target: [
                reportName : 'TestNG Report',
                reportDir  : 'test-output',
                reportFiles: 'index.html',
                keepAll    : true
            ])
        }
    }
}