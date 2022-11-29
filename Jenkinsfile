pipeline {
  agent any 
    stages{
      stage('Git Checkout'){
         steps{
           git branch: 'main', url: 'https://github.com/abassimarwen/Optimizers-core.git'
         }
      }
      stage('Testing maven'){
         steps{
           sh """mvn -version"""
         }
      }
      stage('Build Docker Image'){
         steps{
           script{
             sh 'docker build -t monimage0:1.0.0 .'
           }
         }
      }
    }  
}