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
    return jdbc.query(
        "SELECT id, name, address, phone, email, password, pin, gender, birthday FROM user",
        (rs, rowNum) -> new User(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("address"),
            rs.getString("phone"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("pin"),
            rs.getString("gender"),
            rs.getDate("birthday").toLocalDate()
        )
    );
  }

  public void save(User user) {
    jdbc.update(
        "INSERT INTO user (id, name, address, phone, email, password, pin, gender, birthday) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
        user.getId(),
        user.getName(),
        user.getAddress(),
        user.getPhone(),
        user.getEmail(),
        user.getPassword(),
        user.getPin(),
        user.getGender(),
        java.sql.Date.valueOf(user.getBirthday()) // LocalDate to SQL Date
    );
  }
}
