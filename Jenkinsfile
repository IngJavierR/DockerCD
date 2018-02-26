pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                dir ('android/'){
                    sh 'echo sdk.dir=$ANDROID_HOME > local.properties'
                    sh 'echo org.gradle.java.home=/usr/lib/jvm/jre-1.8.0-openjdk-1.8.0.161-0.b14.el7_4.x86_64 >> gradle.properties'
                    sh 'yes | /opt/android-sdk/tools/bin/sdkmanager --licenses'
                    sh 'cp -R /opt/android-sdk/licenses licenses/'
                    sh './gradlew build clean --stacktrace'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing5'
            }
        }
        stage('Docker') {
            steps {
                echo 'Docker...'
                sh 'docker run --privileged -d -p 6080:6080 -p 5554:5554 -p 5555:5555 -e DEVICE="Samsung Galaxy S6" -v $PWDapp/release:/root/tmp --name android-container butomo1989/docker-android-x86-7.1.1'
            }
        }
    }
}