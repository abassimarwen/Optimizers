pipeline {
  agent any 
    stages{
      stage('Git Checkout'){
         steps{
           git branch: 'main', url: 'https://github.com/abassimarwen/Optimizers-core.git'
         }
      }
      stage('Unit Testing'){
         steps{
           sh 'mvn test'
         }
      }
    }  
}