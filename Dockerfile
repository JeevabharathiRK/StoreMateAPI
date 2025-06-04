# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:24-jdk

# Install Gradle globally
RUN apt-get update && apt-get install -y wget unzip && \
    wget https://services.gradle.org/distributions/gradle-8.14-bin.zip && \
    unzip gradle-8.14-bin.zip -d /opt && \
    ln -s /opt/gradle-8.14/bin/gradle /usr/bin/gradle

# Set the working directory inside the container
WORKDIR /app

# Copy your entire project into the container
COPY . .

# Expose the port your Spring Boot app runs on
EXPOSE 80

# Run the jar file
ENTRYPOINT ["gradle", "bootRun", "--no-daemon"]
