FROM openjdk:11
COPY target/Accounts-0.0.1-SNAPSHOT.jar Accounts-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Accounts-0.0.1-SNAPSHOT.jar"]