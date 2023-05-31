pipeline {
    agent any
    stages {
        stage("Build jar") {
            steps {
                script {
                    echo "Building the images"
                    sh "mvn package"
                }
            }
        }
        stage("Building and pushing the image") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: "Docker", usernameVariable: "USR", passwordVariable: "PASS")]) {
                        sh "docker build -t hari851995/java:v1.3"
                        sh "echo $PASS | docker login -u $USR --password-stdin"
                        sh "docker push hari851995/java:v1.3"
                    }
                }
            }
        }
        stage("Deploying into server") {
            steps {
                script {
                    echo "Deploying into server"
                }
            }
        }
    }
}
