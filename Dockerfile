FROM maven:3.8.2-jdk-8

WORKDIR /tpachat
COPY . .
RUN mvn -T 2C clean package -Dmaven.test.skip -DskipTests

CMD mvn spring-boot:run