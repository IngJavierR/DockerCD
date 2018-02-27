pipeline {
    agent any
    stages {
        stage('Docker') {
            steps {
                docker.image('butomo1989/docker-android-x86-7.1.1').withRun('--privileged -p 6080:6080 -p 5554:5554 -p 5555:5555 -e DEVICE="Samsung Galaxy S6"') { c ->
                    sh 'pwd'
                }
            }
        }
    }
}