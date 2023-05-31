pipeline {
    agent any
    tools{
        maven "mvn-3.9.2"
    }
    stages {
        stage("Build jar"){
            script {
                echo "Building the jar file"
                sh "mvn package"
            }
        }
        stage("Building and pushing the image"){
            script{
                withCredentials([usernamePassword(credentialsId: "Docker", usernameVariable: "USR", passwordVariable: "PASS")]) {
                    sh "docker build -t hari851995/java:v1.3 ."
                    sh "echo $PASS | docker login -u $USR --password-stdin"
                    sh "docker push hari851995/java:v1.3"
                }
            }
        }
        stage("Deploying into server") {
            script {
                echo "Deploying into server"
            }
        }
    }
}
