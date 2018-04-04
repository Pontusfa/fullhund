pipeline {
    agent any

    tools {
        jdk 'java10'
    }

    stages {
        stage('test') {
            steps {
                sh './gradlew clean build test'
            }
        }
    }
}
