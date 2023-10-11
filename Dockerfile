FROM eclipse-temurin:17
WORKDIR /template
COPY ./target/template.jar /template/tmeplate.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "/template/template.jar"]