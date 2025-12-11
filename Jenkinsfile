
pipeline {
  agent any

  tools {
    maven 'M2_HOME'
    jdk 'JAVA_HOME'
  }


  stages {
    stage('git') {
      steps {
        git branch:'main', url:'https://github.com/saharhamza2/Foyer.git'
        }
      }
    }
  
    stage('Build & Test - Maven') {
      steps {
        echo "Lancement du build Maven..."
        sh "mvn -B clean compile"
      }
    }

  }   
  post {
    success {
      echo "Pipeline terminé avec succès"
    }
    failure {
      echo "Pipeline échoué. Vérifie les logs."
    }
   }
}
