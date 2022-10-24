FROM openjdk:17-alpine
COPY ./build/libs/*.jar ./app/customer.jar
EXPOSE 8082:8082
CMD ["java","-jar","./app/customer.jar"]