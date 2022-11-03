FROM openjdk:17-alpine
COPY ./build/libs/*.jar ./app/okaymdn.jar
EXPOSE 8761:8761
CMD ["java","-jar","./app/okaymdn.jar"]
