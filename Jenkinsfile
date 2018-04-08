pipeline {
    agent any

    tools {
        jdk 'java9'
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

        stage('code analysis') {
            steps {
                jacoco(execPattern: '**/build/jacoco/**.exec',classPattern: '**/build/classes',sourcePattern: 'src/main/java')

                withSonarQubeEnv('sonarqube') {
                    sh './gradlew --info sonarqube -Dsonar.host.url=https://fullhund.pontusfa.lk/sonarqube -Dsonar.login=507fb9f6440be992e1b4e559a1c98ad2fcf0f430'
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

}
