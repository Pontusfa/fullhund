pipeline {
    agent any

    tools {
        jdk 'java10'
    }

    stages {
        stage('build') {
            steps {
                sh './gradlew clean'
                sh './gradlew classes'
            }
        }

        stage('test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('code analysis') {
            steps {
                jacoco(execPattern: '**/build/jacoco/**.exec',
                    classPattern: '**/build/classes',
                    sourcePattern: '**/src/main/java')

                sh './gradlew pitest || true'
                sh './gradlew lint || true'

                withSonarQubeEnv('sonarqube') {
                    sh './gradlew sonarqube -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN'
                }

                script {
                    timeout(time: 3, unit: 'MINUTES') {
                        def qualityGate = waitForQualityGate()
                        if (qualityGate.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qualityGate.status}"
                        }
                    }
                }
            }
        }

        stage('archive') {
            steps {
                sh './gradlew :runner:assembleDist'
                archiveArtifacts artifacts: 'runner/build/distributions/Fullhund*', onlyIfSuccessful: true
            }
        }
         stage('archive') {
            steps {
                //TODO
            }
         }
    }

    post {
        success {
            publishHTML([
                allowMissing: false, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: '**/build/docs/javadoc/',
                reportFiles: 'index.html',
                reportTitles: 'Javadoc',
                reportName: 'Javadoc'])
        }

        always {
            junit '**/build/test-results/**/*.xml'

            publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: '**/build/reports/tests/test/',
                reportFiles: 'index.html',
                reportTitles: 'Unit Tests',
                reportName: 'Unit Tests'])

            sh './gradlew jacocoTestReport'

            publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: '**/build/reports/jacoco/test/html/',
                reportFiles: 'index.html',
                reportTitles: 'Code Coverage',
                reportName: 'Code Coverage'])

            publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: '**/build/reports/pitest/',
                reportFiles: 'index.html',
                reportTitles: 'PITest',
                reportName: 'PITest'])
        }
    }
}
