pipeline {
    agent any
    stages {
        stage('Docker') {
            steps {
                docker.image('mysql:5').withRun('-p 3306:3306') {
                    /* do things */
                }
            }
        }
    }
}