pipeline {
    agent any
    tools {
        maven "mvn-3.9.2"
    }
    stages {
        stage("Build Jar") {
            steps {
                echo "Building the Jar file"
                sh "mvn package"
            }
        }
        stage("Building and pushing image") {
            steps {
                echo "Building and publishing the image"
                sh "docker build -t hari851995/java:jav1.1 ."
                withCredentials([usernamePassword(credentialsId: "Docker", usernameVariable: "USR", passwordVariable: "PASS")])
                sh "echo "$PASS" | docker login -u $USR --password-stdin"
                sh "docker push hari851995/java:jav1.1"
            }
        }
        stage("Deploying into server"){
            steps{
                echo "Deploying into the server"
            }
        }
            
    }
}
