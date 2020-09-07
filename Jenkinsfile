pipeline {
    agent { docker { image 'node:latest' } }
    stages {
        stage('build') {
            steps {
                sh 'cd web'
                sh 'npm install'
                sh 'npm run build'
            }
        }
    }
}