FROM openjdk:17-alpine
COPY ./build/libs/*.jar ./app/gateway.jar
EXPOSE 9999:9999
CMD ["java","-jar","./app/gateway.jar"]
