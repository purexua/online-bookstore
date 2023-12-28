package com.purexua.pojo;

import lombok.Data;

@Data
public class User {
  private Integer userId;
  private String userName;
  private String password;
  private String realName;
  private String email;
  private String address;
  private String phoneNumber;
  private Double wallet;
}
