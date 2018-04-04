pipeline {
    agent any

    tools {
        jdk 'java10'
    }

    stages {
        stage('test') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build test jacocoTestReport'
            }
        }

        stage('code coverage') {
                    steps {
            jacoco(execPattern:'build/jacoco/*.exec',classPattern:'build/classes/java/main',sourcePattern:'src/main/java')

        }
        }

        stage('publish reports') {
            steps {
                junit 'build/test-results/**/*.xml'

                publishHTML([
                    reportDir: 'build/reports/tests/test/',
                    reportFiles: 'index.html',
                    reportName: 'Test report'])

                     publishHTML([
                                        reportDir: 'build/reports/coverage/',
                                        reportFiles: 'index.html',
                                        reportName: 'Cove coverage report'])
            }
        }
    }
}
