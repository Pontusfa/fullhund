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
                sh './gradlew test jacocoTestReport'
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
                  reportName: 'Javadoc'])
              }
         }

        stage('publish reports') {
            steps {
                junit 'build/test-results/**/*.xml'

                publishHTML([
                    allowMissing: false, alwaysLinkToLastBuild: false,  keepAll: false,
                    reportDir: 'build/reports/tests/test/',
                    reportFiles: 'index.html',
                    reportTitles: 'Unit Tests',
                    reportName: 'Unit Tests'])

                 publishHTML([
                    allowMissing: false, alwaysLinkToLastBuild: false,  keepAll: false,
                    reportDir: 'build/reports/jacoco/test/html/',
                    reportFiles: 'index.html',
                    reportTitles: 'Code Coverage',
                    reportName: 'Code Coverage'])


            }
        }
    }
}
