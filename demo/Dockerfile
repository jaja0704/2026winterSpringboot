# FROM eclipse-temurin:8-jre
# EXPOSE 8080
# COPY target/keelungsights.jar keelungsights.jar
# ENTRYPOINT ["java","-jar","keelungsights.jar"]

#
# 第一階段：編譯 (Build Stage)
#
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# 複製所有原始碼與 maven wrapper 到容器內
COPY . ./

# 執行編譯與打包
RUN mvn clean package -DskipTests

#
# 第二階段：執行 (Run Stage)
#
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# 從第一階段把 0.0.1-SNAPSHOT.jar 拿過來，並重新命名為 app.jar
COPY --from=build /app/target/0.0.1-SNAPSHOT.jar app.jar

# 宣告應用程式使用的 port (假設是 8080，請依實際情況修改)
EXPOSE 8080

# 啟動應用程式，永遠只需要指定 app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]