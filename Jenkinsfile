#!/usr/bin/env groovy
library identifier: "Jenkins-shared-library", retriever: modernSCM(
    [$class: "GitSCMSource", remote: "https://github.com/Hari8595/Jenkins-shared-library.git"]
)
def gv
pipeline {
    agent any
    tools {
        maven "mvn-3.9.2"
    }
    stages{
        stage("Init"){
            steps {
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage("Build jar") {
            steps{
                script {
                    buildJar()
                }
            }
        }
        stage("Image") {
            steps {
                script{
                    build "hari851995/java:hari1.2"
                    login()
                    push "hari851995/java:hari1.2"
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    gv.deploy()
                }
            }
        }
    }
}