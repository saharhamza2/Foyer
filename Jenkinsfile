pipeline {
  agent any
  
  environment {
    DOCKER_CREDENTIALS_ID = 'docker-hub-creds'
    DOCKER_REPO = 'saharhamza/alpine'
    DOCKER_TAG = '1.0.0'
  }

  tools {
    maven 'M2_HOME'
    jdk 'JAVA_HOME'
  }


  stages {

   stage('Trigger Webhook') {
            steps {
                echo 'Webhook déclenché avec succès'
            }
        }	

    stage('Checkout ') {
     steps {
                checkout scm
                script {
                    env.GIT_COMMIT_SHORT = env.GIT_COMMIT.take(7)
                    env.IMAGE_TAG = "${DOCKER_REPO}:${DOCKER_TAG}-${GIT_COMMIT_SHORT}"
                    echo "Image Docker : ${env.IMAGE_TAG}"
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

	stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat '''
                    mvn -B sonar:sonar ^
                      -Dsonar.projectKey=Foyer ^
                      -Dsonar.projectName=Foyer ^
                      -Dsonar.java.binaries=target/classes
                    '''
                }
            }
        }


    stage('Build Docker Image') {
            steps {
                echo 'Construction de l’image Docker'
                bat 'docker build -t %IMAGE_TAG% .'
            }
        }

      stage('Push Docker Image') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: DOCKER_CREDENTIALS_ID,
                        usernameVariable: 'saharhamza',
                        passwordVariable: 'sahar123*'
                    )
                ]) {
                    bat '''
                    echo sahar123* | docker login -u saharhamza --password-stdin
                    docker push %IMAGE_TAG%
                    docker logout
                    '''
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                echo 'Déploiement sur Kubernetes'

                bat '''
                kubectl set image deployment/spring-app spring-app=%IMAGE_TAG% -n devops
                kubectl rollout status deployment/spring-app -n devops
                '''
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
