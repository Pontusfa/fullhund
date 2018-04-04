pipeline {
    agent any

    tools {
        jdk 'java10'
    }

    stages {
        stage('test') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build test'
            }
        }

        stage('reports') {
            steps {
                junit 'build/report/**/*.xml'
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/test', reportFiles: 'index.html', reportName: 'Testeri', reportTitles: 'Testandet'])

            }
        }
    }
}
