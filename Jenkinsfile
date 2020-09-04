pipeline {
    agent { docker { image 'node:lts-alpine' } }
    stages {
        stage('build') {
            steps {
                bat 'npm --version'
            }
        }
    }
}