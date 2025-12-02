pipeline {
  agent any

  environment {
    GIT_BRANCH = 'main'
    REGISTRY = "docker.io"
    IMAGE_NAME = "saharhamza/foyer-app"
    DOCKER_CREDENTIALS = "docker-creds"
  }

  // webhook GitHub = déclenche automatiquement à chaque commit push
  triggers { }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Commit info') {
      steps {
        script {
          COMMIT_SHORT = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
          echo "Commit détecté : ${COMMIT_SHORT}"
          env.COMMIT_SHORT = COMMIT_SHORT
        }
      }
    }

    stage('Maven build') {
      steps {
        sh 'mvn -B clean package -DskipTests'
      }
    }

    stage('Docker build & push') {
      steps {
        script {
          def tagBuild = "${env.REGISTRY}/${env.IMAGE_NAME}:${env.BUILD_NUMBER}"
          def tagCommit = "${env.REGISTRY}/${env.IMAGE_NAME}:${env.COMMIT_SHORT}"

          withCredentials([usernamePassword(credentialsId: env.DOCKER_CREDENTIALS, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            sh """
              echo "$DOCKER_PASS" | docker login ${REGISTRY} --username "$DOCKER_USER" --password-stdin
              docker build -t ${tagBuild} -t ${tagCommit} .
              docker push ${tagBuild}
              docker push ${tagCommit}
              docker logout ${REGISTRY}
            """
          }
        }
      }
    }
  }

  post {
    success {
      echo "Image poussée : ${env.IMAGE_NAME}:${env.BUILD_NUMBER} et ${env.COMMIT_SHORT}"
    }
  }
}
