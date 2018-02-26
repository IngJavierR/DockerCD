pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                dir 'android/'
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