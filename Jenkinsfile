pipeline {
    agent any

    tools {
        jdk 'java10'
    }

    stages {
        stage('build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean classes'
            }
        }

        stage('test') {
            steps {
                sh './gradlew test'
                junit 'build/test-results/**/*.xml'
            }
        }

        stage('javadoc') {
            steps {
                sh './gradlew javadoc'

                publishHTML([
                  allowMissing: false, alwaysLinkToLastBuild: false,  keepAll: false,
                  reportDir: 'build/docs/javadoc/',
                  reportFiles: 'index.html',
                  reportTitles: 'Javadoc',
                  reportName: 'Documentation'])
              }
         }

        stage('publish reports') {
            steps {
                sh './gradlew jacocoTestReport'

                publishHTML([
                    allowMissing: false, alwaysLinkToLastBuild: false,  keepAll: false,
                    reportDir: 'build/reports/jacoco/test/html/',
                    reportFiles: 'index.html',
                    reportTitles: 'Code Coverage',
                    reportName: 'Documentation'])

                publishHTML([
                    allowMissing: false, alwaysLinkToLastBuild: false,  keepAll: false,
                    reportDir: 'build/reports/tests/test/',
                    reportFiles: 'index.html',
                    reportTitles: 'Unit Tests',
                    reportName: 'Documentation'])
            }
        }
    }
}
