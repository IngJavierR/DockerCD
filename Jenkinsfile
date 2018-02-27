pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                dir ('android/'){
                    sh 'echo sdk.dir=$ANDROID_HOME > local.properties'
                    sh 'yes | /opt/android-sdk/tools/bin/sdkmanager --licenses'
                    sh 'cp -R /opt/android-sdk/licenses licenses/'
                    sh './gradlew build clean'
                }
            }
        }
        stage('Generate Apk') {
            steps{
                dir ('android/'){
                    sh './gradlew assembleDebug'
                }
            }
        }
        stage('Docker') {
            steps {
                sh 'docker run --privileged -d -p 6080:6080 -p 5554:5554 -p 5555:5555 -e DEVICE="Samsung Galaxy S6" --name android-container butomo1989/docker-android-x86-7.1.1'
                sh 'while ! mysqladmin ping -hdb --silent; do sleep 1; done'
            }
        }
    post { 
        always { 
            deleteDir()
            }
        success {
            echo 'I succeeeded!'
            }
        unstable {
            echo 'I am unstable :/'
            }
        failure {
            echo 'I failed :('
            }
        changed {
            echo 'Things were different before...'
            }
        }
    }
}