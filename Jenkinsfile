
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
        script {
          GIT_COMMIT_SHORT = sh(returnStdout: true, script: "git rev-parse --short HEAD").trim()
          env.GIT_COMMIT_SHORT = GIT_COMMIT_SHORT
          echo "Commit short: ${GIT_COMMIT_SHORT}"
        }
      }
    }
  
    stage('Build & Test - Maven') {
      steps {
        echo "Lancement du build Maven..."
        sh "mvn -B clean compile"
      }
      post {
        failure {
          echo "Build Maven failed — arrête le pipeline."
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
