pipeline {
    agent any

    stages {

        stage('Clone projet') {
            steps {
                git branch: 'main', url: 'https://github.com/saharhamza2/Foyer.git'
            }
        }

        stage('Build Docker image') {
            steps {
                echo "Construction de l'image Docker..."
                bat 'docker build -t foyer-app .'
            }
        }

        stage('Run container') {
            steps {
                echo "Lancement du container Docker..."
                bat 'docker run --rm foyer-app'
            }
        }
    }

    post {
        success {
            echo "Pipeline Docker terminé avec succès !"
        }
        failure {
            echo "Le pipeline a échoué."
        }
    }
}
