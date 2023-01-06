#RUN ./create-package.sh
FROM openjdk:11
#FROM maslick/minimalka:jdk11
VOLUME /tmp
ADD target/item-0.0.1-SNAPSHOT.jar item-0.0.1-SNAPSHOT.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","item-0.0.1-SNAPSHOT.jar"]