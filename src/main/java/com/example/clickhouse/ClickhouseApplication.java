package com.example.clickhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;

@SpringBootApplication(exclude = JdbcRepositoriesAutoConfiguration.class)
public class ClickhouseApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClickhouseApplication.class, args);
  }

}
