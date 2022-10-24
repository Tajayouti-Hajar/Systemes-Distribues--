FROM openjdk:17-alpine
COPY ./build/libs/*.jar ./app/billing.jar
EXPOSE 8083:8083
CMD ["java", "-jar", "./app/billing.jar"]