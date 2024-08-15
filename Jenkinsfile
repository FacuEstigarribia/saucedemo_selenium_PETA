pipeline {
    agent any

    tools{
        maven 'M3'
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone repo from github
                git url: 'https://github.com/FacuEstigarribia/saucedemo_selenium_PETA.git'
            }
        }

        stage('Build') {
            steps {
                // Build project with Maven
                sh './mvn clean install'

            }
        }

        stage('Run Tests') {
            steps {
                // Execute Testng suite
                sh './mvnw test -DsuiteXmlFile=src/test/resources/suites/jenkins_job.xml'
            }
        }

        stage('Publish Test Results') {
            steps {
                // Publish test results
                publishTestNGResults(pattern: '**/target/surefire-reports/testng-results.xml')
            }
        }
    }

    post {
        always {
            // Clean any resource
            cleanWs()
        }
        success {
            // Notify success case
            echo 'Tests passed successfully!'
        }
        failure {
            // Notify error case
            echo 'Tests failed. Check the reports for details.'
        }
    }
}
