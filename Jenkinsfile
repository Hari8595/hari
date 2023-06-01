@Library ("Jenkins-shared-library")
def gv
pipeline {
    agent any
    tools {
        maven "mvn-3.9.2"
    }
    stages {
        stage("Init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Build jar") {
            steps {
                script {
                buildJar()
                }
            }
        }
        stage("Building and pushing the image") {
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script {
                image()
                }
            }
        }
        stage("Deploying into server") {
            when{
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script {
                    gv.deploy()
                }
            }
        }
    }
}
