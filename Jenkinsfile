
/*environment {
  APP_NAME = "test"
  BUILD_TYPE = "debug"
}*/

pipeline{
	agent any
	
    stages {
	    /*stage ('Detect build type') {
			steps {
				echo "Get build type....."
				script {
					if (env.BRANCH_NAME == 'develop' || env.CHANGE_TARGET == 'develop') {
						env.BUILD_TYPE = 'debug'
					} else if (env.BRANCH_NAME == 'master' || env.CHANGE_TARGET == 'master') {
						env.BUILD_TYPE = 'release'
					}
				}
			}
		}*/
		
        stage('Clean & Compile'){
             steps {
			    echo "start clearning and building......"
				bat "gradlew clean"
                //bat "gradlew compile${BUILD_TYPE}Sources"
				bat "gradlew compileDebugSources"
             }
        }
		
		stage('Unit test&Code coverage ') {
			steps {
				echo "start unit testing......"
				//bat "gradlew test${BUILD_TYPE}UnitTest"
				bat "gradlew testDebugUnitTest"
				bat "gradlew jacocoTestReport"
				bat "gradlew jacocoTestCoverageVerification"
			}
			
		}

    }

}