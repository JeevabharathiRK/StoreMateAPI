FROM eclipse-temurin:24-jdk

RUN apt-get update && apt-get install -y wget unzip

WORKDIR /app

ENV GRADLE_VERSION=8.14
RUN wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip \
    && mv gradle-${GRADLE_VERSION} /opt/gradle \
    && ln -s /opt/gradle/bin/gradle /usr/bin/gradle \
    && rm gradle-${GRADLE_VERSION}-bin.zip

COPY . .

RUN gradle build --no-daemon -x test

EXPOSE 8080

CMD ["java", "-jar", "build/libs/storemateapi-0.0.1-SNAPSHOT.jar"]