package com.example.clickhouse.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Long id;
  private String name;
  private String address;
  private String phone;
  private String email;
  private String password;
  private String pin;
  private String gender;
  private LocalDate birthday;
}
