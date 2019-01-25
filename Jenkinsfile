pipeline {
    agent {
        // 此处设定构建环境，目前可选有
        // java-8,python-2.7,python-3.5,build-essential,ruby-2.3,go-1.7
        label "java-8"
    }
    stages  {
        stage("Script") {
            steps {
                parallel "etc": {
                  	script{
                      	sh 'ls -l'
                  	}
                }, "当前目录": {
                    sh 'pwd'
                }
            }
          
        }
        stage("环境"){
      		steps {
            	sh 'whoami'
                sh 'echo $HOME'
                sh 'ls -la $HOME'
    	    }
    	}
        stage("构建") {
            steps {
                echo "构建中..."
              	sh 'mvn package'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                echo "构建完成."
            }
        }

      	stage("运行"){
      		steps {
            	sh 'java -jar target/java-0.0.1-SNAPSHOT.jar'
    	    }
    	}
      	
    }
}
