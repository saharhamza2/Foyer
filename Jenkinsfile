
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

    stage('Build Docker Image') {
      steps {
        script {
          IMAGE_TAG_LATEST = "${env.DOCKER_REPO}:${env.DOCKER_TAG}"
          IMAGE_TAG_COMMIT = "${env.DOCKER_REPO}:${env.DOCKER_TAG}-${env.GIT_COMMIT_SHORT}"
          echo "Build docker image ${IMAGE_TAG_LATEST} and ${IMAGE_TAG_COMMIT}"
          sh "docker build -f /home/vboxuser/docker/DockerFile -t ${IMAGE_TAG_COMMIT} ."
        }
      }
    }

    stage('Build & Push Docker (CLI)') {
      steps {
        script {
          def shortSha = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
          def imageCommit = "${env.DOCKER_REPO}:${env.DOCKER_TAG}-${shortSha}"

          sh "docker build -f /home/vboxuser/docker/DockerFile -t ${image} -t ${imageCommit} ."

          withCredentials([usernamePassword(credentialsId: 'docker-hub-creds',
                                            usernameVariable: 'saharhamza',
                                            passwordVariable: 'Sahar123*')]) {

            sh 'echo "Docker&-*2024" | docker login -u saharhamza --password-stdin'

            sh "docker push ${imageCommit}"

            sh 'docker logout || true'
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
