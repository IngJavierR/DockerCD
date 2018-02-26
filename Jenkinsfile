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
                echo 'Deploying...'
                docker.image('butomo1989/docker-android-x86-7.1.1').withRun('--privileged -d -p 6080:6080 -p 5554:5554 -p 5555:5555 -e DEVICE="Samsung Galaxy S6" -v $PWD/app/release:/root/tmp --name android-container') { c ->
                    sh 'pwd'
                }
            }
        }
    }
}