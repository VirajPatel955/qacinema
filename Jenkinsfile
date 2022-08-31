pipeline {
	agent any
	stages{
		stage('Test Application'){
			steps{
			sh 'mvn clean'
			}
		}
		stage('Save Tests'){
			steps{
			sh 'mkdir -p /home/jenkins/Tests/${BUILD_NUMBER}_tests/'
			sh 'mv ./target/surefire-reports/*.txt /home/jenkins/Tests/${BUILD_NUMBER}_tests/'
			}
		}
		stage('SSH Build Deploy'){
			steps{
			sh '''ssh -i "~/.ssh/jenkins_key" jenkins@18.170.36.93 << EOF
			rm -rf qacinema
			git clone https://github.com/itisianpetts/qacinema.git
			cd qacinema
			rm -f ./src/main/resources/application.properties
			echo 'spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://qacinema.cxwwrn7oq8ws.eu-west-2.rds.amazonaws.com:3306/qacinemaDB
spring.datasource.data=classpath:data-dev.sql
spring.datasource.username=admin
spring.datasource.password=qacinema' > ./src/main/resources/application.properties
			mvn clean package
			'''
			}
		}
		stage('Moving War'){
			steps{
			sh '''ssh -i "~/.ssh/jenkins_key" jenkins@<***app_instance_ip***>	 << EOF
			cd <***your_repository_name***>
			mkdir -p /home/jenkins/Wars
			mv ./target/*.war /home/jenkins/Wars/project_war.war
			'''
			}
                }
		stage('Stopping Service'){
			steps{
			sh '''ssh -i "~/.ssh/jenkins_key" jenkins@<***app_instance_ip***> << EOF
			cd <***your_repository_name***>
			bash stopservice.sh
			'''
			}
		}
		stage('Create new service file'){
			steps{
			sh '''ssh -i "~/.ssh/jenkins_key" jenkins@<***app_instance_ip***> << EOF
			mkdir -p /home/jenkins/appservice
			echo '#!/bin/bash
sudo java -jar /home/jenkins/Wars/project_war.war' > /home/jenkins/appservice/start.sh
sudo chmod +x /home/jenkins/appservice/start.sh
echo '[Unit]
Description=My SpringBoot App
[Service]
User=ubuntu
Type=simple
ExecStart=/home/jenkins/appservice/start.sh
[Install]
WantedBy=multi-user.target' > /home/jenkins/myApp.service
sudo mv /home/jenkins/myApp.service /etc/systemd/system/myApp.service
			'''
			}
		}
		stage('Reload and restart service'){
			steps{
			sh '''ssh -i "~/.ssh/jenkins_key" jenkins@<***app_instance_ip***> << EOF
			sudo systemctl daemon-reload
			sudo systemctl restart myApp
			'''
			}
		}

	}
}
