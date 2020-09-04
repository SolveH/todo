pipeline {
    agent { docker { image 'node:lts-alpine' } }
    stages {
        stage('build') {
            steps {
                bash 'npm --version'
            }
        }
    }
}