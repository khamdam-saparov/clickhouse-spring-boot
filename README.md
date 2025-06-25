Spring Boot + ClickHouse Integration (Gradle)
A simple Spring Boot application demonstrating how to connect and interact with ClickHouse , a fast open-source OLAP database management system. This project uses Gradle as the build tool.

📌 Features
Connects to ClickHouse using JDBC.
Uses Spring Data JPA style repositories.
Exposes REST endpoints to query data from ClickHouse.
Demonstrates configuration via application.yml.
🧰 Requirements
Before running the project, ensure you have:

Java 17+
Gradle 7.x or higher
ClickHouse Server (local or remote)
Spring Boot 3.x compatible dependencies
🛠️ Setup Instructions
1. Install ClickHouse (if not already installed)
You can install ClickHouse locally using Docker:

docker run -d --name clickhouse-server \
  -p 8123:8123 \
  -p 9000:9000 \
  -p 9009:9009 \
  --ulimit nofile=262144:262144 \
  clickhouse/clickhouse-server
Create a test database and table:

sql

CREATE DATABASE default;

CREATE TABLE default.user (
    id UInt64,
    name String
) ENGINE = MergeTree()
ORDER BY (id);
Insert some sample data:

sql

INSERT INTO default.user (id, name) VALUES
(1, 'Alice'),
(2, 'Bob');
2. Add Dependencies to build.gradle
Add the ClickHouse JDBC driver dependency to your build.gradle:
    implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'com.clickhouse:clickhouse-jdbc:0.7.1'
    implementation 'org.lz4:lz4-java:1.8.0'

⚠️ Make sure to check for the latest version on Maven Central . 

3. Configure Application
Update src/main/resources/application.yml with your ClickHouse credentials:

spring:
  datasource:
    url: jdbc:clickhouse://localhost:8123/testdb
    username: default
    password:
    driver-class-name: ru.yandex.clickhouse.ClickHouseDriver
🏃 Run the Application
Use the following command to start the application:

./gradlew bootRun
The server will start on port 8080.
