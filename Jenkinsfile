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
                sh './gradlew test || true'
            }
        }

        stage('code analysis') {
            steps {
                jacoco(execPattern: '**/build/jacoco/**.exec',
                    classPattern: '**/build/classes',
                    sourcePattern: '**/src/main/java')

                sh './gradlew pitest || true'

                withSonarQubeEnv('sonarqube') {
                    sh './gradlew --info sonarqube -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN'
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
                sh './gradlew assembleDist'
                archiveArtifacts artifacts: 'build/distributions/Fullhund*', onlyIfSuccessful: true
            }
        }
    }

    post {
        success {
            publishHTML([
                allowMissing: false, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: 'build/docs/javadoc/',
                reportFiles: 'index.html',
                reportTitles: 'Javadoc',
                reportName: 'Javadoc'])
        }

        always {
            junit 'build/test-results/**/*.xml'

            publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: 'build/reports/tests/test/',
                reportFiles: 'index.html',
                reportTitles: 'Unit Tests',
                reportName: 'Unit Tests'])

            sh './gradlew jacocoTestReport'

            publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: 'build/reports/jacoco/test/html/',
                reportFiles: 'index.html',
                reportTitles: 'Code Coverage',
                reportName: 'Code Coverage'])

            publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: true,  keepAll: false,
                reportDir: 'build/reports/pitest/html/',
                reportFiles: 'index.html',
                reportTitles: 'PITest',
                reportName: 'PITest'])
        }
    }
}
