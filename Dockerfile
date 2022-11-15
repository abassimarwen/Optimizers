
FROM maven:3.8.2-jdk-8

WORKDIR C/Users/user/Downloads/devops
COPY . .
COPY pom.xml .
COPY src ./src
RUN mvn clean package -Dmaven.test.skip -DskipTests


CMD mvn spring-boot:run
