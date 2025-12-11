pipeline {
  agent any

  environment {
    DOCKER_CREDENTIALS_ID = 'docker-creds'
    DOCKER_REPO = 'saharhamza/alpine'
    DOCKER_TAG = '1.0.0'
  }

  tools {
    maven 'M2_HOME'
    jdk 'JAVA_HOME'
  }


  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

     stage('Get short SHA') {
      steps {
        script {
          // Récupère le short SHA proprement (sans afficher la commande)
          def shortShaRaw = bat(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
          def shortSha = shortShaRaw.tokenize()[0]   // protection si des retours bizarres
          env.GIT_COMMIT_SHORT = shortSha
          echo "Commit short = ${shortSha}"
        }
      }
    }

    stage('Build & Test - Maven') {
      steps {
        echo "Lancement du build Maven..."
        bat "mvn -B clean compile"
      }
      post {
        failure {
          echo "Build Maven failed — arrête le pipeline."
        }
      }
    }

    stage('Build Docker Image') {
      steps {
        script {
                  def IMAGE_TAG_COMMIT = "${env.DOCKER_REPO}:${env.DOCKER_TAG}-${env.GIT_COMMIT_SHORT}"
                  def imageLatest = "${env.DOCKER_REPO}:latest"
                  
                  echo "Building docker image..."
                  bat "docker build -t ${IMAGE_TAG_COMMIT} ."
        
                  withCredentials([usernamePassword(credentialsId: 'docker-hub-creds',
                                                    usernameVariable: 'saharhamza',
                                                    passwordVariable: 'sahar123*')]) {
        
                    bat 'echo "Docker&-*2024" | docker login -u saharhamza --password-stdin'

                    bat "docker tag ${IMAGE_TAG_COMMIT} ${imageLatest}
                    
                    bat "docker push ${IMAGE_TAG_COMMIT}"
        
                    bat 'docker logout || true'
                   }  
              }
          }
      }
  }

  post {
    success {
      echo "Pipeline terminé avec succès — image poussée : ${DOCKER_REPO}:${DOCKER_TAG}"
    }
    failure {
      echo "Pipeline échoué. Vérifie les logs."
    }
   }
}
