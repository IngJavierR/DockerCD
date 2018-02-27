pipeline {
    agent any
    stages {
        stage('Docker') {
            def mysql = docker.image('mysql:5');
            mysql.pull()
            docker.withRegistry('https://docker.example.com/', 'docker-registry-login') {
                mysql.withRun(-p 3306:3306){ c->
                    sh 'pwd'
                }
            }
        }
    }
}