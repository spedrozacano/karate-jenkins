pipeline {
    agent any

    stages {

        stage('Compile Stage') {
            steps {
                script {
                    def mvnHome = tool name: 'apache-maven-3.9.6', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        sh "${mvnHome}\\bin\\mvn clean compile"
                    }
                }

            }
        }

        stage('Test Stage') {
            steps {

                script {
                    def mvnHome = tool name: 'apache-maven-3.9.6', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]) {
                        sh "${mvnHome}/bin/mvn' test -Dtest=RunnerReport"
                    }
                }
            }

        }

        stage('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                        fileIncludePattern: "**/cucumber.json",
                        jsonReportDirectory: 'target'
            }
        }

    }

}
