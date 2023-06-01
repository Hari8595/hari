#!/usr/bin/env groovy
@Library ("Jenkins-shared-library")
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
                    image "hari851995/java:hari1.1"
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