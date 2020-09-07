pipeline {
    agent none
    stages {
        stage('build') {
            agent {
                dockerfile { 
                    dir 'web'
                } 
            }
            steps {
                echo 'things should be fine by now'
            }
        }
    }
}