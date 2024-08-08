pipeline {
    agent any

    tools{
        maven 'M3'
    }
    stages {
        stage('Checkout') {
            steps {
                // Clona tu repositorio desde Git
                git url: 'https://github.com/FacuEstigarribia/saucedemo_selenium_PETA.git'
            }
        }

        stage('Build') {
            steps {
                // Compila el proyecto con Maven o Gradle
                sh './mvn clean install' // Usar mvnw si usas Maven Wrapper

            }
        }

        stage('Run Tests') {
            steps {
                // Ejecuta la suite de TestNG
                sh './mvnw test -DsuiteXmlFile=src/test/resources/suites/jenkins_job.xml'
            }
        }

        stage('Publish Test Results') {
            steps {
                // Publica los resultados de las pruebas
                publishTestNGResults(pattern: '**/target/surefire-reports/testng-results.xml')
            }
        }
    }

    post {
        always {
            // Limpiar cualquier recurso
            cleanWs()
        }
        success {
            // Notificación en caso de éxito
            echo 'Tests passed successfully!'
        }
        failure {
            // Notificación en caso de fallo
            echo 'Tests failed. Check the reports for details.'
        }
    }
}
