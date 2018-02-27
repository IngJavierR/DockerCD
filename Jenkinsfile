pipeline {
    agent any
    stages {
        stage('Docker') {
            agent {
                docker {
                    image 'mysql:5'
                    args '-p 3306:3306'
                }
            }
            steps {
                sh 'pwd'
            }
        }
    }
}