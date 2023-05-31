def gv
pipeline {
    agent any
    parameters{
        string(name: "TYPE", defaultValue: "", description: "Type to be display")
        choice(name: "CHOICE", choices: ["1.1.1", "1.2.1", "1.2.3"], description: "Choose the choice")
        booleanParam(name: "STAGE", defaultValue: true, description: "")
    }
    tools {
        maven "mvn-3.9.2"
    }
    environment {
        VERSION = "1.2.3"
    } 
    stages {
        stage("Init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Build") {
            steps {
                script {
                    gv.buildApp ()
                }
            }
        }
        stage("Test") {
            when{
                expression{
                    params.STAGE
                }
            }
            steps {
                script {
                    gv.testApp ()
                }
            }
        }
        stage("Deploy") {
            input {
                message "Select the environment"
                ok "done"
                parameters {
                    choice(name: "ENV", choices: ["Development", "Production", "Testing"], description: "")
                }
            }
            steps {
                echo "environment is params.ENV"
                script {
                    gv.deployApp ()
                }
                echo "type is params.TYPE"
            }
        }
    }
    post {
        always {
            echo "success or failure"
        }
        success {
            echo "success"
        }
        failure {
            echo "failure"
        }
    }
}
