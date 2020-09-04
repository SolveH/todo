pipeline {
    agent { docker { image 'node:lts-alpine' } }
    stages {
        stage('build') {
            environment {
                  HOME="."
            }
            steps {
                bash 'npm --version'
            }
        }
    }
}