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
                junit 'build/test-results/**/*.xml'
            }
        }
    }
}
