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
            steps {
                dir ('android/'){
                    sh './gradlew assembleDebug'
                }
            }
        }
        stage('Docker') {
            steps {
                sh 'docker run --privileged -d -p 6080:6080 -p 5554:5554 -p 5555:5555 -e DEVICE="Samsung Galaxy S6" --name android-container butomo1989/docker-android-x86-7.1.1'
            }
        }
        stage('Expresso test') {
            steps {
                sleep 60
                sh '/opt/android-sdk/platform-tools/adb kill-server'
                sh '/opt/android-sdk/platform-tools/adb start-server'
                dir ('android/'){
                    sh './gradlew connectedAndroidTest -i'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'curl "https://dashboard.applivery.com/api/builds" \
                    -X POST \
                    -H "Authorization:42c00e9014a6d943c1e9fe75ed0050de253a3620" \
                    -F app="5a906745ccc70a0d57513329" \
                    -F versionName="Test version name" \
                    -F notes="Bug fixing" \
                    -F notify="true" \
                    -F os="android" \
                    -F tags="tag1" \
                    -F package=@"$WORKSPACE/android/app/build/outputs/apk/debug/app-debug.apk"'
            }
        }
    }
    post { 
        always { 
            deleteDir()
            sh 'docker rm -f $(docker ps -aq)'
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