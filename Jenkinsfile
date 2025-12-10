pipeline {
  agent any

  // Optional parameter: user can choose which browser run (both|chrome|firefox)
  parameters {
    choice(name: 'RUN_BROWSERS', choices: ['both','chrome','firefox'], description: 'Which browser(s) to run')
  }

  environment {
    // If you use WebDriverManager in tests you don't need explicit driver paths.
    MAVEN_CMD = "mvn clean test -Dheadless=true"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Run Tests') {
      steps {
        script {
          // prepare a map for parallel runs
          def branches = [:]

          if (params.RUN_BROWSERS == 'both' || params.RUN_BROWSERS == 'chrome') {
            branches['Chrome (headless)'] = {
              if (isUnix()) {
                sh "${env.MAVEN_CMD} -Dbrowser=chrome"
              } else {
                bat "\"${env.MAVEN_CMD} -Dbrowser=chrome\""
              }
            }
          }

          if (params.RUN_BROWSERS == 'both' || params.RUN_BROWSERS == 'firefox') {
            branches['Firefox (headless)'] = {
              if (isUnix()) {
                sh "${env.MAVEN_CMD} -Dbrowser=firefox"
              } else {
                bat "\"${env.MAVEN_CMD} -Dbrowser=firefox\""
              }
            }
          }

          // run selected branches in parallel (single branch if only one selected)
          if (branches.size() == 1) {
            // run single branch directly (avoids overhead)
            branches.values().first().call()
          } else {
            parallel branches
          }
        }
      }
    }
  }

  post {
    always {
      // archive TestNG artifacts for download
      archiveArtifacts artifacts: 'test-output/**', fingerprint: true

      // publish HTML report per-build (requires HTML Publisher Plugin)
      script {
        publishHTML (target: [
          reportName: 'TestNG Report',
          reportDir: 'test-output',
          reportFiles: 'emailable-report.html',
          keepAll: true,
          alwaysLinkToLastBuild: false,
          allowMissing: false
        ])
      }

      // optional: show console summary (keeps job green/red as per stage results)
      echo "Build finished - artifacts archived and HTML published (if present)."
    }
  }
}