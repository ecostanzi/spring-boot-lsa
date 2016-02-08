FROM java
MAINTAINER Enrico Costanzi "enrico.costanzi@gmail.com"
VOLUME /tmp
ADD target/lsa.war /lsa.war
RUN bash -c 'touch /lsa.war'
EXPOSE 8081
ENTRYPOINT ["java","-jar","/lsa.war"]
