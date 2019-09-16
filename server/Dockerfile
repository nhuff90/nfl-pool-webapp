FROM frolvlad/alpine-python3
MAINTAINER nhuff90@gmail.com

RUN apk add --no-cache openjdk8
RUN apk add --update python
ADD ./python /python
ADD ./target/demo-0.0.2-SNAPSHOT.jar demo-0.0.2-SNAPSHOT.jar

RUN pip install --upgrade pip && \
    pip install --no-cache-dir pytz && \
    pip install --no-cache-dir requests

EXPOSE 8090
CMD ["java", "-jar", "demo-0.0.2-SNAPSHOT.jar"]
