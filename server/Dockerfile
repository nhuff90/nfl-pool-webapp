FROM alpine:edge
MAINTAINER nhuff90@gmail.com
RUN apk add --no-cache openjdk8
RUN apk add --update python
ADD ./target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8090
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
