pipeline {
    agent {
        // 此处设定构建环境，目前可选有
        // java-8,python-2.7,python-3.5,build-essential,ruby-2.3,go-1.7
        label "java-8"
    }
    stages  {
        
        stage("检出") {
            steps {
                checkout(
                  [$class: 'GitSCM', branches: [[name: env.GIT_BUILD_REF]], 
                  userRemoteConfigs: [[url: env.GIT_REPO_URL]]]
                )
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

        stage("测试") {
            steps {
                parallel "单元测试": {
                    echo "单元测试中..."
                    sh 'mvn test'
                    echo "单元测试完成."
                    // junit 'target/surefire-reports/*.xml'
                }, "接口测试": {
                    echo "接口测试中..."
                    // 请在这里放置您项目代码的单元测试调用过程，例如 mvn test
                    echo "接口测试完成."
                    // 请在这里放置收集接口测试报告的调用过程，JUnit 示例：junit 'target/surefire-reports/*.xml'
                }, "测试敏感词":{
                    echo "Username: ${env.username}"
            		echo "Password: ${env.password}"
                }

            }
          
        }
      	stage("运行"){
      		steps {
            	sh 'java -jar target/java-0.0.1-SNAPSHOT.jar'
    	    }
    	}
      	stage("Script") {
            steps {
                parallel "etc": {
                  	script{
                      	sh 'find /etc/'
                  	}
                }, "ip address": {
                    sh 'ip addr show'
                }
            }
          
        }
    }
}
