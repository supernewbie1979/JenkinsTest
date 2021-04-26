
environment {
  APP_NAME = "test"
  BUILD_TYPE = "debug"
}

void setBuildStatus(String message, String state) {
  step([
      $class: "GitHubCommitStatusSetter",
      reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://github.com/supernewbie1979/JenkinsTest"],
      contextSource: [$class: "ManuallyEnteredCommitContextSource", context: "ci/jenkins/build-status"],
      errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
  ]);
}

pipeline{
	agent any
	
    stages {
	    stage ('Detect build type') {
			steps {
				echo "Get build type....."
				script {
					if (env.BRANCH_NAME == 'develop' || env.CHANGE_TARGET == 'develop') {
						BUILD_TYPE = 'Debug'
					} else if (env.BRANCH_NAME == 'master' || env.CHANGE_TARGET == 'master') {
						BUILD_TYPE = 'Release'
					}
				}
			}
		}
		
        stage('Clean & Compile'){
             steps {
			    echo "start clearning and building......"
				bat "gradlew clean"
                bat "gradlew compile${BUILD_TYPE}Sources"
				//bat "gradlew compileDebugSources"
             }
        }
		
		stage('Unit test&Code coverage ') {
			steps {
				echo "start unit testing......"
				bat "gradlew test${BUILD_TYPE}UnitTest"
				//bat "gradlew testDebugUnitTest"
				bat "gradlew jacocoTestReport"
				bat "gradlew jacocoTestCoverageVerification"
			}
			
		}

    }
	
	post {
		success {
			setBuildStatus("Build succeeded", "SUCCESS");
		}
		failure {
			setBuildStatus("Build failed", "FAILURE");
		}
  }

}