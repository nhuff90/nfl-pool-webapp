To Run:

In client project :
ng build –prod

In server project:
clean package install -Dmaven.test.skip=true


In docker - not using:
docker build -t nfl-web-app .
docker run -p 8090:8090 nfl-web-app





scp -i C:\Users\Nate\Desktop\AWS\EC2KP.pem demo-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-224-61-229.us-east-2.compute.amazonaws.com:/home/ec2-user

https://www.nexsoftsys.com/articles/how-to-deploy-spring-boot-application-in-aws-ec2-server-quickly.html

Copy JAR to EC2
https://github.com/juanfrans/notes/wiki/Copying-Files-Between-Local-Computer-and-Instance-(AWS)

On EC2
sudo yum install java-1.8.0
sudo yum remove java-1.7.0-openjdk



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
