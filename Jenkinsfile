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

        stage('unit tests') {
            steps {
                sh './gradlew test'
            }

            post {
                always {
                    junit 'build/test-results/**/*.xml'
                }
            }
        }

        stage('acceptance tests') {
            steps {
                sh './gradlew cucumber'
            }

            post {
                always {
                    cucumber fileIncludePattern: 'report.json', jsonReportDirectory: 'build/cucumber', sortingMethod: 'ALPHABETICAL'
                }
            }
        }

        stage('generate javadoc') {
            steps {
                sh './gradlew javadoc'

                publishHTML([
                  allowMissing: false, alwaysLinkToLastBuild: true,  keepAll: false,
                  reportDir: 'build/docs/javadoc/',
                  reportFiles: 'index.html',
                  reportTitles: 'Javadoc',
                  reportName: 'Javadoc'])
              }
         }

        stage('publish reports') {
            steps {
                sh './gradlew jacocoTestReport'

                publishHTML([
                    allowMissing: false, alwaysLinkToLastBuild: true,  keepAll: false,
                    reportDir: 'build/reports/jacoco/test/html/',
                    reportFiles: 'index.html',
                    reportTitles: 'Code Coverage',
                    reportName: 'Code Coverage'])

                publishHTML([
                    allowMissing: false, alwaysLinkToLastBuild: true,  keepAll: false,
                    reportDir: 'build/reports/tests/test/',
                    reportFiles: 'index.html',
                    reportTitles: 'Unit Tests',
                    reportName: 'Unit Tests'])
            }
        }
    }

     post {
        always {

        }
     }
}
