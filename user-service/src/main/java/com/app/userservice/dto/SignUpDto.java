package com.app.userservice.dto;

import lombok.Data;

@Data
public class SignUpDto {
  public String name;
  public String email;
  public String password;
}
