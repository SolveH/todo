pipeline {
    agent { docker { image 'node:14' } }
    stages {
        stage('build') {
            steps {
                sh 'npm --version'
            }
        }
    }
}