# Amazon Corretto 17 JDK tabanlı Alpine imajını kullan
FROM amazoncorretto:17-alpine-jdk

# JAR dosyasının yolunu tanımla
ARG JAR_FILE=build/libs/transaction-service.jar

# JAR dosyasını kopyala
COPY ${JAR_FILE} app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "/app.jar"]
