# ==== BUILD =====
# Use a Maven base image
FROM maven:3.6.0-jdk-11-slim AS build

# Set the working directory to /app inside the container
WORKDIR /app

# Copy sources and pom files
COPY src /home/app/src
COPY pom.xml /home/app

# Restore packeges based on pom file?
RUN mvn -f /home/app/pom.xml clean package

# ==== RUN =======
# Use a open JDK base image
FROM openjdk:11-jre-slim

# Copy jar
COPY --from=build /home/app/target/abstract-library-api.jar /usr/local/lib/abstract-library-api.jar

# Expose the port
EXPOSE 8080

# Run jar
ENTRYPOINT ["java","-jar","/usr/local/lib/abstract-library-api.jar"]