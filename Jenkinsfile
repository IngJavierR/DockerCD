pipeline {
    agent any
    stages {
        stage('Docker') {
            steps {
                docker.image('butomo1989/docker-android-x86-7.1.1').withRun('-e "DEVICE=Samsung Galaxy S6" -p 6080:6080') { c ->
                    sh 'pwd'
                }
            }
        }
    }
}