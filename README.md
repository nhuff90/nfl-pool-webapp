To Run:

In client project :
ng build –prod

In server project:
clean package install -Dmaven.test.skip=true


In docker:
docker build -t nfl-web-app .
docker run -p 8090:8090 nfl-web-app
















No - https://www.freecodecamp.org/news/how-to-deploy-a-node-js-application-to-amazon-web-services-using-docker-81c2a2d7225b/

https://medium.com/underscoretec/deploy-your-own-custom-docker-image-on-amazon-ecs-b1584e62484


EC2 Configureation
sudo yum install java-1.8.0
