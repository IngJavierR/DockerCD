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
        stage('Docker') {
            steps {
                sh 'docker run --privileged -d -p 6080:6080 -p 5554:5554 -p 5555:5555 -e DEVICE="Samsung Galaxy S6" -v $PWDapp/release:/root/tmp --name android-container butomo1989/docker-android-x86-7.1.1'
            }
        }
    }
}