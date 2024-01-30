pipeline {
    agent any

    stages {

        stage('Compile Stage') {
            steps {
                script {
                    def MVN_HOME = tool name: 'maven_3_9_6', type: 'maven'
                    withEnv(["PATH+MAVEN=${MVN_HOME}/bin"]) {
                        sh "${MVN_HOME}\\bin\\mvn clean compile"
                    }
                }

            }
        }

        stage('Test Stage') {
            steps {
                script {
                    def MVN_HOME = tool name: 'maven_3_9_6', type: 'maven'
                    withEnv(["PATH+MAVEN=${MVN_HOME}/bin"]) {
                        sh "${MVN_HOME}\\bin\\mvn test -Dtest=RunnerReport"
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
