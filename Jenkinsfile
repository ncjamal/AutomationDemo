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

        stage('Deploy Report to GitHub Pages') {
            steps {
                withCredentials([string(credentialsId: 'github-token', variable: 'TOKEN')]) {
                    bat """
                        git config --global user.email "jenkins@example.com"
                        git config --global user.name "Jenkins"

                        if exist gh-pages rmdir /s /q gh-pages
                        git clone --branch gh-pages https://%TOKEN%@github.com/ncjamal/AutomationDemo.git gh-pages

                        cd gh-pages

                        mkdir jenkins-build-%BUILD_NUMBER%
                        xcopy /E /I /Y ..\\test-output\\* jenkins-build-%BUILD_NUMBER%\\

                        git add .
                        git commit -m "Jenkins deploy report for build %BUILD_NUMBER%"
                        git push
                    """
                }
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