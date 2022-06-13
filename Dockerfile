FROM eclipse-temurin:17-jdk-alpine
COPY target/gateway-api-*.jar gateway-api.jar
CMD ["java", "-jar", "gateway-api.jar"]