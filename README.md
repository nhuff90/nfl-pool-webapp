To Run:

In client project:
ng build –prod

In server project:
clean package install -Dmaven.test.skip=true

CMD Docker:
docker build -t nhuff90/nfl-app:prod .
docker push nhuff90/nfl-app:prod


Powershell:
Invoke-Expression -Command (Get-ECRLoginCommand -Region us-east-2).Command
docker build -t nfl-web-app-repo:v0.0.12 .
docker tag nfl-web-app-repo:v0.0.12 117837584658.dkr.ecr.us-east-2.amazonaws.com/nfl-web-app-repo:v0.0.12
docker push 117837584658.dkr.ecr.us-east-2.amazonaws.com/nfl-web-app-repo:v0.0.12


EC2:
sudo yum update
sudo yum install java-1.8.0
sudo yum remove java-1.7.0-openjdk
sudo yum install docker -y
sudo service docker start
docker run -p 8090:8090 nhuff90/nfl-app:prod















----------OLD------------


In docker - not using:
#docker build -t nfl-web-app .
#docker run -p 8090:8090 nfl-web-app

locally:
docker build -t nhuff90/nfl-app:prod .
docker push nhuff90/nfl-app:prod

on EC2:
sudo docker pull nhuff90/nfl-app:prod
sudo docker run -p 8090:8090 nhuff90/nfl-app:prod





push jar file to EC2:
scp -i C:\Users\Nate\Desktop\AWS\EC2KP.pem demo-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-224-61-229.us-east-2.compute.amazonaws.com:/home/ec2-user

https://www.nexsoftsys.com/articles/how-to-deploy-spring-boot-application-in-aws-ec2-server-quickly.html

Copy JAR to EC2
https://github.com/juanfrans/notes/wiki/Copying-Files-Between-Local-Computer-and-Instance-(AWS)

On EC2 startup:
sudo yum update
sudo yum install java-1.8.0
sudo yum remove java-1.7.0-openjdk
sudo yum install docker -y
sudo service docker start



Configure Docker on EC2 (https://serverfault.com/questions/836198/how-to-install-docker-on-aws-ec2-instance-with-ami-ce-ee-update):
To get Docker running on the AWS AMI you should follow the steps below (these are all assuming you have ssh'd on to the EC2 instance).

    Update the packages on your instance

    [ec2-user ~]$ sudo yum update -y

    Install Docker

    [ec2-user ~]$ sudo yum install docker -y

    Start the Docker Service

    [ec2-user ~]$ sudo service docker start

    Add the ec2-user to the docker group so you can execute Docker commands without using sudo.

    [ec2-user ~]$ sudo usermod -a -G docker ec2-user

You should then be able to run all of the docker commands without requiring sudo. After running the 4th command I did need to logout and log back in for the change to take effect.
