# FROM eclipse-temurin:8-jre
# EXPOSE 8080
# COPY target/keelungsights.jar keelungsights.jar
# ENTRYPOINT ["java","-jar","keelungsights.jar"]

#
# 第一階段：編譯 (Build Stage)
#
FROM maven:3.8.6-eclipse-temurin-21 AS build
WORKDIR /demo
COPY . ./
RUN mvn clean package -DskipTests -X

#
# 第二階段：執行 (Run Stage)
#
FROM eclipse-temurin:21-jre-alpine
WORKDIR /demo
COPY --from=build /demo/target/0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

# 啟動應用程式，永遠只需要指定 app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]