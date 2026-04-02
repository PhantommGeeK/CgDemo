pipeline {
    agent any
    
    tools {
        maven 'mvn'
        jdk 'Java 26'
    }
  
    environment {
        APP_NAME = 'SpringBootMockTestDemo'
        JAR_NAME = 'SpringBootMockTestDemo-0.0.1-SNAPSHOT.jar'
        DEPLOY_PATH = 'C:\\apps'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/PhantommGeeK/CgDemo.git',
                    credentialsId: 'fd97a57a-6fbb-4d9a-82b4-9d51b95bc60a'
                echo 'Pulled project from GitHub'
            }
        }
        stage('Build') {
            steps {
                dir('SpringBootMockTestDemo') {
                    bat 'mvn clean compile'
                }
                echo 'Compiled the project'
            }
        }
        stage('Test') {
            steps {
                dir('SpringBootMockTestDemo') {
                    bat 'mvn test'
                }
                echo 'Tests completed'
            }
        }
        stage('Package') {
            steps {
                dir('SpringBootMockTestDemo') {
                    bat 'mvn package -DskipTests'
                }
                echo 'JAR file created'
            }
        }
        stage('Deploy') {
            steps {
                dir('SpringBootMockTestDemo') {
                    bat '''
                    echo === DEPLOY STARTED ===
                    if not exist "%DEPLOY_PATH%" mkdir "%DEPLOY_PATH%"
                    echo Killing old app...
                    taskkill /F /IM java.exe || echo No Java process running
                    echo Copying new jar...
                    copy /Y target\\SpringBootMockTestDemo-0.0.1-SNAPSHOT.jar "%DEPLOY_PATH%\\%JAR_NAME%"
                    cd /D "%DEPLOY_PATH%"
                    echo Starting app...
                    start /B java -jar "%JAR_NAME%" > deploy.log 2>&1
                    echo Deployment finished!
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment completed successfully!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}
