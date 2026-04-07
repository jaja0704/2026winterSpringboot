# FROM eclipse-temurin:8-jre
# EXPOSE 8080
# COPY target/keelungsights.jar keelungsights.jar
# ENTRYPOINT ["java","-jar","keelungsights.jar"]

FROM maven:3.8.6-eclipse-temurin-8 AS build
WORKDIR /home/app
COPY pom.xml .
RUN mvn dependency:go-offline

# 複製原始碼並進行打包
COPY src ./src
RUN mvn clean package -DskipTests

#
# 第二階段：Package stage
#
FROM eclipse-temurin:8-jre
EXPOSE 8080
COPY --from=build /home/app/target/keelungsights.jar keelungsights.jar
ENTRYPOINT ["java","-jar","keelungsights.jar"]