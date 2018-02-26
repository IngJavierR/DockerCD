pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                dir '${env.WORKSPACE}/android/'
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing5'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying5'
            }
        }
    }
}