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
      stage('ls'){
         steps{
           sh """ls"""
         }
      }
      stage('Build'){
         steps{
           script{
             sh """sudo docker build ."""
           }
         }
      }
    }  
}