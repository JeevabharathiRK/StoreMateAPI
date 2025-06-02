# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:24-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY build/libs/storemateapi-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 80

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]