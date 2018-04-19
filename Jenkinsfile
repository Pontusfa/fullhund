pipeline {
    agent any

    tools {
        jdk 'java9'
    }

    stages {
        stage('clean') {
            steps {
                sh 'rm -rf build/{cucumber,jacoco,reports,test-reports}'
            }
        }

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
                    cucumber(fileIncludePattern: 'report.json',
                            jsonReportDirectory: 'build/cucumber',
                            sortingMethod: 'ALPHABETICAL')
                }
            }
        }

        stage('code analysis') {
            steps {
                jacoco(execPattern: '**/build/jacoco/**.exec',
                       classPattern: '**/build/classes',
                       sourcePattern: '**/src/main/java')

                withSonarQubeEnv('sonarqube') {
                    sh './gradlew --info sonarqube -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN'
                }

                script {
                    timeout(time: 15, unit: 'MINUTES') {
                        def qualityGate = waitForQualityGate()
                        if (qualityGate.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qualityGate.status}"
                        }
                    }
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
    }
    post {
        always {
            sh './gradlew jacocoTestReport'

            publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: 'build/reports/',
                reportFiles: 'jacoco/test/html/index.html,tests/test/index.html',
                reportTitles: 'Code Coverage,Unit Tests',
                reportName: 'Tests'])
        }
    }
}
