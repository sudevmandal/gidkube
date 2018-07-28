pipeline {
    agent any
    tools {
        Ant 'Ant 1.9.6'        
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${ANT_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh ' cd ServletTutorial ant -v'
            }
        }

        stage ('Deploy to Octopus') {
            steps {
                withCredentials([string(credentialsId: 'OctopusAPIKey', variable: 'APIKey')]) {
                    sh """
                        ${tool('Octo CLI')}/Octo push --package target/ServletTutorial.war --replace-existing --server http://ec2-54-146-131-176.compute-1.amazonaws.com --apiKey ${APIKey}
                        ${tool('Octo CLI')}/Octo create-release --project "kubedemo" --server http://ec2-54-146-131-176.compute-1.amazonaws.com --apiKey ${APIKey}
                        ${tool('Octo CLI')}/Octo deploy-release --project "kubedemo" --version latest --deployto Kube-Dev --server http://ec2-54-146-131-176.compute-1.amazonaws.com --apiKey ${APIKey}
                    """
                }
            }
        }
    }
}
