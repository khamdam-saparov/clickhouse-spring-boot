package com.example.clickhouse.model;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  private final JdbcTemplate jdbc;

  public UserRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public List<User> findAll() {
    return jdbc.query("SELECT id, name FROM user", (rs, rowNum) ->
        new User(rs.getLong("id"), rs.getString("name")));
  }

  public void save(User user) {
    jdbc.update("INSERT INTO user (id, name) VALUES (?, ?)", user.getId(), user.getName());
  }
}
