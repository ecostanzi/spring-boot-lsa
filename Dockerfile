FROM java
MAINTAINER Enrico Costanzi "enrico.costanzi@gmail.com"
VOLUME /tmp
ADD target/lsa.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
