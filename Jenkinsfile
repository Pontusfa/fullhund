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

        stage('publish reports') {
            steps {
                junit 'build/test-results/**/*.xml'

                publishHTML([
                    reportDir: 'build/reports/tests/test/',
                    reportFiles: 'index.html',
                    reportName: 'Unit Tests'])

                 publishHTML([
                    reportDir: 'build/reports/jacoco/test/html/',
                    reportFiles: 'index.html',
                    reportName: 'Code Coverage'])

                 publishHTML([
                    reportDir: 'build/docs/javadoc/',
                    reportFiles: 'index.html',
                    reportName: 'Javadocs'])
            }
        }

# jacoco doesn't work with java 10 at the moment
#        stage('code coverage') {
#            steps {
#                jacoco(execPattern:'build/jacoco/test.exec',classPattern:'build/classes/java/main',sourcePattern:'src/main/java')
#            }
#        }
    }
}
